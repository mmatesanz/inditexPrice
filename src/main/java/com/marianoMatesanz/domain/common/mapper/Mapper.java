package com.marianoMatesanz.domain.common.mapper;

import com.marianoMatesanz.application.response.FindPriceResponse;
import com.marianoMatesanz.domain.common.utils.UtilsDate;
import com.marianoMatesanz.infrastructure.repository.PriceEntity;

public class Mapper {

	
	public static FindPriceResponse priceToFindPriceResponse (PriceEntity price) {
		
		
		FindPriceResponse response = FindPriceResponse.builder()
				.productId(price.getProductId())
				.brand_id(price.getBrand().getBrandId() )
				.priceList(price.getPriceList())
				.startDate(UtilsDate.convertToLocalDateTime( price.getStartDate()) )
				.endDate(UtilsDate.convertToLocalDateTime( price.getEndDate()) )
				.price(price.getPrice())
				.build();
		
		return response;
		
	}
}
