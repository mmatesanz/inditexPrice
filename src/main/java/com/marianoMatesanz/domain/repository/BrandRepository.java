package com.marianoMatesanz.domain.repository;

import java.util.List;
import java.util.Optional;

import com.marianoMatesanz.infrastructure.repository.BrandEntity;

public interface BrandRepository {

	List<BrandEntity> findAll();

	Optional<BrandEntity> findById(long id);


}
