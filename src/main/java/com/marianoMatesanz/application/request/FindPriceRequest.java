package com.marianoMatesanz.application.request;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class FindPriceRequest {

    private LocalDateTime startDate;
    
    private String productId;

    private Long brand_id;

}
