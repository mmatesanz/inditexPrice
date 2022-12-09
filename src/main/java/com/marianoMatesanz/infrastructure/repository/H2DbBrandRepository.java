package com.marianoMatesanz.infrastructure.repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.marianoMatesanz.application.response.FindPriceResponse;
import com.marianoMatesanz.domain.common.mapper.Mapper;
import com.marianoMatesanz.domain.repository.BrandRepository;
import com.marianoMatesanz.domain.repository.PriceRepository;

@Component
public class H2DbBrandRepository implements BrandRepository {

	private final SpringDataH2DbBrandRepository brandRepository;

	@Autowired
	public H2DbBrandRepository(SpringDataH2DbBrandRepository brandRepository) {
		this.brandRepository = brandRepository;
	}

	@Override
	public List<BrandEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<BrandEntity> findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}




}
