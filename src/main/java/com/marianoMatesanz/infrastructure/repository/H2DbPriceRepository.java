package com.marianoMatesanz.infrastructure.repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.marianoMatesanz.application.response.FindPriceResponse;
import com.marianoMatesanz.domain.Price;
import com.marianoMatesanz.domain.common.mapper.Mapper;
import com.marianoMatesanz.domain.repository.PriceRepository;

@Component
public class H2DbPriceRepository implements PriceRepository {

	private final SpringDataH2DbPriceRepository priceRepository;

	@Autowired
	public H2DbPriceRepository(SpringDataH2DbPriceRepository priceRepository) {
		this.priceRepository = priceRepository;
	}

	@Override
	public List<FindPriceResponse> findByPrice(String productId, Long brand_id, Date dateStar) {

		Collection<PriceEntity> prices = priceRepository.findByPrice(productId, brand_id, dateStar);

		List<FindPriceResponse> pricesResponse = prices.stream().map(price -> Mapper.priceToFindPriceResponse(price))
				.collect(Collectors.toList());

		return pricesResponse;
	}

	@Override
	public List<Price> findAll() {

		List<PriceEntity> priceList = priceRepository.findAll();

		List<Price> pricesResponse = priceList.stream().map(priceE -> priceE.toPrice()).collect(Collectors.toList());

		return pricesResponse;
	}

	@Override
	public Optional<Price> findById(long id) {

		Optional<PriceEntity> priceEntity = priceRepository.findById(id);

		if (priceEntity.isPresent()) {
			return Optional.of(priceEntity.get().toPrice());
		} else {
			return Optional.empty();
		}
	}

	@Override
	public void delete(Price price) {

		PriceEntity priceEntity = PriceEntity.builder()
				.systemPriceId(price.getSystemPriceId())
				.build();
		
		priceRepository.delete(priceEntity );

	}

	@Override
	public Optional<Price> updateStartDate(Long systemPriceId) {
		
		Optional<PriceEntity> updatePrice = priceRepository.findById(systemPriceId);

		if (updatePrice.isPresent()) {

			updatePrice.get().setStartDate(new Date());			
			
			PriceEntity priceNew = priceRepository.save(updatePrice.get());

			return Optional.of( priceNew.toPrice() );
		}else {
			return Optional.empty();
		}

	}

}
