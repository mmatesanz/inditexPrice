package com.marianoMatesanz.domain.common.constants;

public interface Constants {
    //Dynamic Statements
    String LOGGER_ENTRY = "Entry [{0}::{1}]";
    String LOGGER_EXIT = "Exit [{0}::{1}]";
    
    public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ" ;
    public static final String DATE_FORMAT_PRICE = "yyyy-MM-dd'-'HH.mm.ssZ" ;
    public static final String  PRODUCT_ID = "35455";
    public static final String  CURR_EUR = "EUR";

    enum PRICE_CURR {EUR, USD, GBP, JPY}
}
