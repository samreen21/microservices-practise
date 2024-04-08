package com.microservice.currencyconversionservice.entity;

import java.math.BigDecimal;

public class CurrencyConversion {

    private Long id;

    private String from;

    private String to;

    private BigDecimal conversionDecimal;

    private BigDecimal quaanity;
    private BigDecimal totalCalculatedAmount;

    private String environment;

    public CurrencyConversion ( ) {
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

    public BigDecimal getConversionDecimal ( ) {
        return conversionDecimal;
    }

    public void setConversionDecimal ( BigDecimal conversionDecimal ) {
        this.conversionDecimal = conversionDecimal;
    }

    public BigDecimal getQuaanity ( ) {
        return quaanity;
    }

    public void setQuaanity ( BigDecimal quaanity ) {
        this.quaanity = quaanity;
    }

    public BigDecimal getTotalCalculatedAmount ( ) {
        return totalCalculatedAmount;
    }

    public void setTotalCalculatedAmount ( BigDecimal totalCalculatedAmount ) {
        this.totalCalculatedAmount = totalCalculatedAmount;
    }

    public String getEnvironment ( ) {
        return environment;
    }

    public void setEnvironment ( String environment ) {
        this.environment = environment;
    }

    public CurrencyConversion ( Long id , String from , String to , BigDecimal conversionDecimal , BigDecimal quaanity , BigDecimal totalCalculatedAmount , String environment ) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionDecimal = conversionDecimal;
        this.quaanity = quaanity;
        this.totalCalculatedAmount = totalCalculatedAmount;
        this.environment = environment;
    }
}
