package com.marianoMatesanz.domain.service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.marianoMatesanz.application.request.FindPriceRequest;
import com.marianoMatesanz.application.response.FindPriceResponse;
import com.marianoMatesanz.domain.Price;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FindPriceServiceTest {

	@Autowired
	private PriceService priceService;

	@Test
	public void findAllPriceTest() {

		List<Price> priceList = priceService.findAll();

		Assert.assertEquals(4, priceList.size());

	}

	@Test
	public void findPriceTest1() {

		LocalDateTime dateStart = LocalDateTime.of(2020, 06, 14, 10, 00, 00);

		FindPriceRequest findPriceRequest = FindPriceRequest.builder().startDate(dateStart).productId("35455")
				.brand_id(1L).build();
		Collection<FindPriceResponse> priceList = priceService.findPrice(findPriceRequest);

		Assert.assertEquals(3, priceList.size());

	}

	@Test
	public void findPriceTest2() {

		LocalDateTime dateStart = LocalDateTime.of(2020, 06, 14, 16, 00, 00);

		FindPriceRequest findPriceRequest = FindPriceRequest.builder().startDate(dateStart).productId("35455")
				.brand_id(1L).build();
		Collection<FindPriceResponse> priceList = priceService.findPrice(findPriceRequest);

		Assert.assertEquals(2, priceList.size());

	}

	@Test
	public void findPriceTest3() {

		LocalDateTime dateStart = LocalDateTime.of(2020, 06, 14, 21, 00, 00);

		FindPriceRequest findPriceRequest = FindPriceRequest.builder().startDate(dateStart).productId("35455")
				.brand_id(1L).build();
		Collection<FindPriceResponse> priceList = priceService.findPrice(findPriceRequest);

		Assert.assertEquals(2, priceList.size());

	}

	@Test
	public void findPriceTest4() {

		LocalDateTime dateStart = LocalDateTime.of(2020, 06, 15, 10, 00, 00);

		FindPriceRequest findPriceRequest = FindPriceRequest.builder().startDate(dateStart).productId("35455")
				.brand_id(1L).build();
		Collection<FindPriceResponse> priceList = priceService.findPrice(findPriceRequest);

		Assert.assertEquals(1, priceList.size());

	}

	@Test
	public void findPriceTest5() {

		LocalDateTime dateStart = LocalDateTime.of(2020, 06, 16, 21, 00, 00);

		FindPriceRequest findPriceRequest = FindPriceRequest.builder().startDate(dateStart).productId("35455")
				.brand_id(1L).build();
		Collection<FindPriceResponse> priceList = priceService.findPrice(findPriceRequest);

		Assert.assertEquals(0, priceList.size());

	}

}
