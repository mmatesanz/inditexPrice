package com.marianoMatesanz.domain.service;

import java.util.List;
import java.util.Optional;

import com.marianoMatesanz.application.request.FindPriceRequest;
import com.marianoMatesanz.application.response.FindPriceResponse;
import com.marianoMatesanz.domain.Price;
import com.marianoMatesanz.infrastructure.repository.PriceEntity;


public interface PriceService {

	List<FindPriceResponse> findPrice(FindPriceRequest findPriceRequest);
	
	List<Price> findAll();

	Optional<Price> findById(long id);

	boolean deleteById(long id);

	Optional<Price> updateStartDate(Price price);


}
