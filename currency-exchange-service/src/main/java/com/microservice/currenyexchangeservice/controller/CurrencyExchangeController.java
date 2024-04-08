package com.microservice.currenyexchangeservice.controller;


import com.microservice.currenyexchangeservice.entity.CurrencyExchange;
import com.microservice.currenyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment env;

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    private CurrencyExchange retrieveExchange( @PathVariable String from,@PathVariable String to){

     CurrencyExchange currencyExchange =   currencyExchangeRepository.findByFromAndTo(from,to);
     if(currencyExchange == null) {
         throw new RuntimeException ( "Unable to find the data for " + from + " to " + to );
     }
        currencyExchange.setEnvironment ( env.getProperty ( "local.server.port" ) );
        return currencyExchange;
    }
}
