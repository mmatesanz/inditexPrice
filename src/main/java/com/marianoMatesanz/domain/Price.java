package com.marianoMatesanz.domain;


import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Price {

	private Long systemPriceId;
    private Brand brand;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int priceList;
    private String productId;
    private int priority;
    private double price;
    private String curr;



   
}
