package com.chaklader.microservices.CurrencyConversionService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Chaklader on Nov, 2021
 */


//@FeignClient(name="currency-exchange", url="localhost:8000")
//@FeignClient(name = "currency-exchange")
@FeignClient(name = "currency-exchange", url = "${CURRENCY_EXCHANGE_SERVICE_HOST:http://localhost}:8000")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{fromCurrencyName}/to/{toCurrencyName}")
    public CurrencyConversion retrieveExchangeValue(@PathVariable String fromCurrencyName, @PathVariable String toCurrencyName);
}
