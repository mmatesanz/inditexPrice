package com.marianoMatesanz.application.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class FindPriceResponse {

    
    private String productId;

    private Long brand_id;

    private int priceList;

    private LocalDateTime startDate;    

    private LocalDateTime endDate;
    
    private double price;
    
}
