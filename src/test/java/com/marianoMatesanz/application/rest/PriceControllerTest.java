package com.marianoMatesanz.application.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.marianoMatesanz.domain.Brand;
import com.marianoMatesanz.domain.Price;
import com.marianoMatesanz.domain.common.constants.Constants;
import com.marianoMatesanz.domain.common.utils.UtilsDate;
import com.marianoMatesanz.domain.service.PriceService;
import com.marianoMatesanz.infrastructure.repository.BrandEntity;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@RunWith(SpringRunner.class)
public class PriceControllerTest implements Constants {

	@InjectMocks
	PriceController priceController;

	@Mock
	private PriceService priceService;

	@Test
	public void testGetAllPrice() {

		List<Price> prices = getMockListPrices();

		when(priceService.findAll()).thenReturn(prices);

		ResponseEntity<List<Price>> result = priceController.getAllPrice();

		assertThat(result.getBody().size()).isEqualTo(prices.size());

	}

	@Test
	public void testGetPriceById() {

		Brand brand1 = Brand.builder().brandId(1L).name("ZARA").build();

		Price price1 = Price.builder().systemPriceId(1l).brand(brand1)
				.startDate(LocalDateTime.of(2020, Month.JUNE, 14, 19, 30, 40))
				.endDate(LocalDateTime.of(2020, Month.DECEMBER, 31, 23, 59, 59))
				.priceList(1)
				.productId(PRODUCT_ID).priority(0).price(35.50).curr(CURR_EUR).build();

		Optional<Price> optPrice = Optional.ofNullable(price1);

		when(priceService.findById(1L)).thenReturn(optPrice);

		ResponseEntity<Price> result = priceController.getPriceById(1L);

		assertThat(result.getBody().getProductId()).isEqualTo(optPrice.get().getProductId());

	}

	@Test
	public void testDeletePriceById() {

		when(priceService.deleteById(1L)).thenReturn(true);

		ResponseEntity<HttpStatus> result = priceController.deletePriceById(1L);

		assertThat(result.getStatusCodeValue()).isEqualTo(200);

	}

	@Test
	public void testUpdateStartDate() {

		Brand brand1 = Brand.builder().brandId(1L).name("ZARA").build();

		Price price1 = Price.builder().brand(brand1)
				.startDate(LocalDateTime.of(2020, Month.JUNE, 14, 19, 30, 40))
				.endDate(LocalDateTime.of(2020, Month.DECEMBER, 31, 23, 59, 59))
				.priceList(1)
				.productId(PRODUCT_ID).priority(0).price(35.50).curr(CURR_EUR).build();

		Price priceUpdate = Price.builder().brand(brand1)
				.startDate(LocalDateTime.of(2020, Month.JUNE, 14, 19, 30, 40))
				.endDate(LocalDateTime.of(2020, Month.DECEMBER, 31, 23, 59, 59))
				.priceList(1)
				.productId(PRODUCT_ID).priority(0).price(35.50).curr(CURR_EUR).build();
		
		Optional<Price> priceOpt = Optional.of(priceUpdate);
		
		when(priceService.updateStartDate(price1)).thenReturn(priceOpt);

		ResponseEntity<Price> result = priceController.updateStartDate(price1);

		assertThat(result.getBody().getStartDate()).isEqualTo(priceUpdate.getStartDate());

	}

	private List<Price> getMockListPrices() {

		Brand brand1 = Brand.builder().brandId(1L).name("ZARA").build();

		Price price1 = Price.builder().brand(brand1)
				//.startDate(UtilsDate.convertStringtoDate("2020-06-14T00:00:00", DATE_FORMAT))
				.startDate(LocalDateTime.of(2020, Month.JUNE, 14, 19, 30, 40))
				.endDate(LocalDateTime.of(2020, Month.DECEMBER, 31, 23, 59, 59))
				//.endDate(UtilsDate.convertStringtoDate("2020-12-31T23.59.59", DATE_FORMAT)).priceList(1)
				.productId(PRODUCT_ID).priority(0).price(35.50).curr(CURR_EUR).build();

//		Price price2 = Price.builder().brand(brand1)
//				.startDate(UtilsDate.convertStringtoDate("2020-06-14T15:00:00", DATE_FORMAT))
//				.endDate(UtilsDate.convertStringtoDate("2020-06-14T18.30.00", DATE_FORMAT)).priceList(2)
//				.productId(PRODUCT_ID).priority(0).price(25.45).curr(CURR_EUR).build();
//
//		Price price3 = Price.builder().brand(brand1)
//				.startDate(UtilsDate.convertStringtoDate("2020-06-15T00:00:00", DATE_FORMAT))
//				.endDate(UtilsDate.convertStringtoDate("2020-06-15T11.00.00", DATE_FORMAT)).priceList(3)
//				.productId(PRODUCT_ID).priority(0).price(30.50).curr(CURR_EUR).build();
//
//		Price price4 = Price.builder().brand(brand1)
//				.startDate(UtilsDate.convertStringtoDate("2020-06-15T16:00:00", DATE_FORMAT))
//				.endDate(UtilsDate.convertStringtoDate("2020-12-31T23.59.59", DATE_FORMAT)).priceList(4)
//				.productId(PRODUCT_ID).priority(0).price(38.95).curr(CURR_EUR).build();

		List<Price> prices = new ArrayList<Price>();
		prices.add(price1);
//		prices.add(price2);
//		prices.add(price3);
//		prices.add(price4);

		return prices;

	}
}
