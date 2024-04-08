package com.microservice.currenyexchangeservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

import jakarta.persistence.Column;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger ( CircuitBreakerController.class );




    @GetMapping("/sample-circuit-breaker")
  //  @Retry ( name ="circuit-breaker-sample-api" ,fallbackMethod = "hardcodedResponse")
    // @Retry (name = "default" ) /* default value will be 3 so 3 times  so if there is any failure it will call the service then return the response*/
  //  @CircuitBreaker ( name ="default",fallbackMethod = "hardcodedResponse" )
    @RateLimiter (name = "default" )/*10s =>1000 calls to this sample api*/
    public String sampleApi(){
        logger.info ( "Sample api call receive" );
         ResponseEntity <String> entity = new RestTemplate (  )
                 .getForEntity ( "http://localhost:8090/some-dummy-url )",String.class);
         return entity.getBody ();

    }


    public String hardcodedResponse(Exception ex){
        return "fallback-response";
    }

}
