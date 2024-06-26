package com.microservice.currencyconversionservice;

import com.microservice.currencyconversionservice.entity.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name ="currency-exchange-service",url="localhost:8091")

@FeignClient(name ="currency-exchange-service")
public interface CurrencyExchangeProxy {

    @GetMapping ("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retrieveExchange( @PathVariable String from, @PathVariable String to);
}

