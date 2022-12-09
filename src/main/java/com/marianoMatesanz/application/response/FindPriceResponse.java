package com.marianoMatesanz.application.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class FindPriceResponse {

    
    /**
     * Product code identifier
     */
    private String productId;

    /**
     * Brand´s id
     */
    private Long brand_id;


    /**
     * Applicable price rate identifier
     */
    private int priceList;

    /**
     * Beginning of the range of dates
     */
    private LocalDateTime startDate;    

    
    /**
     * End of date range
     */
    private LocalDateTime endDate;
    
    
    /**
     * Final sale price
     */
    private double price;
    
}
