package com.marianoMatesanz.domain.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.marianoMatesanz.application.response.FindPriceResponse;
import com.marianoMatesanz.domain.Price;

public interface PriceRepository {

	List<FindPriceResponse> findByPrice(String productId, Long brand_id, Date convertToDateViaSqlTimestamp);

	List<Price> findAll();

	Optional<Price> findById(long id);

	void delete(Price priceEntity);

	Optional<Price> updateStartDate(Long systemPriceId); 

}
