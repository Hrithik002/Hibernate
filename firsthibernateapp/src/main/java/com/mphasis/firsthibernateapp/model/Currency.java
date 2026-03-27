package com.mphasis.firsthibernateapp.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Currency {

    private String currencyCode;
    private String currencySymbol;
    private String locale;

    public Currency() {
    }

    public Currency(String currencyCode, String currencySymbol, String locale) {
        this.currencyCode = currencyCode;
        this.currencySymbol = currencySymbol;
        this.locale = locale;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }
}