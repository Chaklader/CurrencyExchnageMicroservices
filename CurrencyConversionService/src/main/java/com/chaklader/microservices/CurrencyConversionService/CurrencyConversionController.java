package com.chaklader.microservices.CurrencyConversionService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Created by Chaklader on Nov, 2021
 */
@RestController
public class CurrencyConversionController {


    final private Logger LOGGER = LoggerFactory.getLogger(CurrencyConversionController.class);

    @Autowired
    private CurrencyExchangeProxy exchangeProxy;

//    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
//    public CurrencyConversion calculateCurrencyConversion(
//        @PathVariable String from,
//        @PathVariable String to,
//        @PathVariable BigDecimal quantity
//    ) {
//
//        Map<String, String> uriVariables = new HashMap<>();
//        uriVariables.put("from", from);
//        uriVariables.put("to", to);
//
//
//        final ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
//            CurrencyConversion.class, uriVariables);
//
//        final CurrencyConversion currencyConversion = responseEntity.getBody();
//
//        return new CurrencyConversion(currencyConversion.getId(),
//            from, to, quantity,
//            currencyConversion.getConversionMultiple(),
//            quantity.multiply(currencyConversion.getConversionMultiple()),
//            currencyConversion.getEnvironment() + " " + "rest template");
//    }


    @GetMapping("/currency-conversion-feign/from/{fromCurrencyName}/to/{toCurrencyName}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversionFeign(
            @PathVariable String fromCurrencyName,
            @PathVariable String toCurrencyName,
            @PathVariable BigDecimal quantity
    ) {

        //CHANGE-KUBERNETES
        LOGGER.info("calculateCurrencyConversionFeign called with {} to {} with {}", fromCurrencyName, toCurrencyName, quantity);

        final CurrencyConversion currencyConversion = exchangeProxy.retrieveExchangeValue(fromCurrencyName, toCurrencyName);

        BigDecimal conversionMultiple = currencyConversion.getConversionMultiple();

        return new CurrencyConversion(currencyConversion.getId(),
                fromCurrencyName, toCurrencyName, quantity,
                conversionMultiple,
                quantity.multiply(conversionMultiple),
                currencyConversion.getEnvironment() + " " + "feign template");
    }
}
