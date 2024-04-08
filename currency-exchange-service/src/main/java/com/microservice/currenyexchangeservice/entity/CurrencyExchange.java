package com.microservice.currenyexchangeservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class CurrencyExchange {

    @Id
    private Long id;

    @Column(name ="currency_from")
    private String from;

    @Column(name ="currency_to")
    private String to;

    private BigDecimal conversionDecimal;

    private String environment;

    public String getEnvironment ( ) {
        return environment;
    }

    public void setEnvironment ( String environment ) {
        this.environment = environment;
    }

    public Long getId ( ) {
        return id;
    }

    public void setId ( Long id ) {
        this.id = id;
    }

    public String getFrom ( ) {
        return from;
    }

    public void setFrom ( String from ) {
        this.from = from;
    }

    public String getTo ( ) {
        return to;
    }

    public void setTo ( String to ) {
        this.to = to;
    }

    public CurrencyExchange ( Long id , String from , String to , BigDecimal conversionDecimal ) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionDecimal = conversionDecimal;
    }

    public CurrencyExchange ( ) {
    }

    public BigDecimal getConversionDecimal ( ) {
        return conversionDecimal;
    }

    public void setConversionDecimal ( BigDecimal conversionDecimal ) {
        this.conversionDecimal = conversionDecimal;
    }
}
