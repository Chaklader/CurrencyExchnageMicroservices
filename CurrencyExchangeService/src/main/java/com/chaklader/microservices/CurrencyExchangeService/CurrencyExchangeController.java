package com.chaklader.microservices.CurrencyExchangeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.core.env.Environment;


@RestController
public class CurrencyExchangeController {


    private final Logger LOGGER = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @Autowired
    private CurrencyExchangeRepository repository;

    @Autowired
    private Environment environment;




    @GetMapping("/currency-exchange/from/{fromCurrencyName}/to/{toCurrencyName}")
    public CurrencyExchange retrieveExchangeValue(
            @PathVariable String fromCurrencyName,
            @PathVariable String toCurrencyName) {

        LOGGER.info("retrieveExchangeValue called with {} to {}", fromCurrencyName, toCurrencyName);

        CurrencyExchange currencyExchange
                = repository.findByFromAndTo(fromCurrencyName, toCurrencyName);

        if (currencyExchange == null) {
            throw new RuntimeException
                    ("Unable to Find data for " + fromCurrencyName + " to " + toCurrencyName);
        }

        String port = environment.getProperty("local.server.port");

        //CHANGE-KUBERNETES
        String host = environment.getProperty("HOSTNAME");
        String version = "v11";

        currencyExchange.setEnvironment(port + " " + version + " " + host);

        return currencyExchange;

    }
}
