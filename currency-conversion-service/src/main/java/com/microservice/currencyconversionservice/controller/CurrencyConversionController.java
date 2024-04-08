package com.microservice.currencyconversionservice.controller;

import com.microservice.currencyconversionservice.CurrencyExchangeProxy;
import com.microservice.currencyconversionservice.entity.CurrencyConversion;
import jdk.jfr.Registered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;

    @GetMapping ( "/currency-conversion/from/{from}/to/{to}/quantity/{quantity}" )
    private CurrencyConversion calculateCurrencyConversion ( @PathVariable String from , @PathVariable String to , @PathVariable BigDecimal quantity ) {

        HashMap < String, String > uriVaribles = new HashMap <> ( );
        uriVaribles.put ( "from" , from );
        uriVaribles.put ( "to" , to );
        ResponseEntity < CurrencyConversion > response = new RestTemplate ( ).getForEntity ( "http://localhost:8091/currency-exchange/from/{from}/to/{to}" , CurrencyConversion.class , uriVaribles );
        CurrencyConversion currencyConversion = response.getBody ( );
        return new CurrencyConversion ( currencyConversion.getId ( ) , from , to , quantity , currencyConversion.getConversionDecimal ( ) ,
                quantity.multiply ( currencyConversion.getConversionDecimal ( ) ) , currencyConversion.getEnvironment ( ) +" resttemplate");
    }

    @GetMapping ( "/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}" )
    private CurrencyConversion calculateCurrencyConversionFeign ( @PathVariable String from , @PathVariable String to , @PathVariable BigDecimal quantity ) {
        CurrencyConversion currencyConversion = currencyExchangeProxy.retrieveExchange ( from , to );
        return new CurrencyConversion ( currencyConversion.getId ( ) , from , to , quantity , currencyConversion.getConversionDecimal ( ) ,
                quantity.multiply ( currencyConversion.getConversionDecimal ( ) ) , currencyConversion.getEnvironment ( ) +" feign");
    }
}