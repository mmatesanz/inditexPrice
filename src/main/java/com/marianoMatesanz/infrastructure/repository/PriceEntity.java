package com.marianoMatesanz.infrastructure.repository;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.marianoMatesanz.domain.Brand;
import com.marianoMatesanz.domain.Price;
import com.marianoMatesanz.domain.common.utils.UtilsDate;

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
@Entity
@Table(name = "PRICES")
@SequenceGenerator(name = "seqPrice", sequenceName = "SEQ_SYSTEM_PRICE_ID")
public class PriceEntity {
    /**
     * Unique Identifier for the Price
     */
    @Id    
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqPrice")
    private Long systemPriceId;
    /**
     * Brand´s id 
     */
    @ManyToOne
    @JoinColumn(name = "BRAND_ID", insertable = true, updatable = true)
    private BrandEntity brand;

    
    /**
     * Beginning of the range of dates
     */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    /**
     * End of date range
     */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    /**
     * Applicable price rate identifier
     */
    @Column
    private int priceList;
    
    /**
     * Product code identifier
     */
    @Column
    private String productId;
    
    /**
     * Price application disambiguator. If two rates coincide in a range of dates, the one with the highest priority is applied
     */
    @Column
    private int priority;

    /**
     * Final sale price
     */
    @Column
    private double price;

    /**
     * Iso coin
     */
    @Column
    private String curr;
    
    public Price toPrice () {
    	
    	Brand brandMap = Brand.builder()
    			.brandId(brand.getBrandId())
    			.name(brand.getName())
    			.build();
    	
    	Price priceMap = Price.builder()
    			.systemPriceId(systemPriceId)
    			.brand( brandMap )
				.productId(productId)
				.startDate(UtilsDate.convertToLocalDateTime(startDate) )
				.endDate(UtilsDate.convertToLocalDateTime( endDate) )
				.priceList( priceList)
				.priority(priority)				
				.price(price)
				.build();
    	
    	return priceMap;
    }



   
}
