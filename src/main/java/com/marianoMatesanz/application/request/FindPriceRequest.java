package com.marianoMatesanz.application.request;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class FindPriceRequest {

    /**
     * Beginning of the range of dates
     */
    private LocalDateTime startDate;
    
    /**
     * Product code identifier
     */
    private String productId;

    /**
     * Brand´s id
     */
    private Long brand_id;

}
