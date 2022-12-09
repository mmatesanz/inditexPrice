package com.marianoMatesanz.domain.repository;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.marianoMatesanz.domain.model.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

	@Query("SELECT p FROM Price p WHERE p.productId = :productId AND p.brand_id.brandId = :brandId AND p.startDate > :startDate") 
	public Collection<Price> findByPrice(String productId, Long brandId, Date startDate);
}
