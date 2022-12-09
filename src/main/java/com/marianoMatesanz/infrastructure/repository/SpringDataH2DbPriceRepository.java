package com.marianoMatesanz.infrastructure.repository;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataH2DbPriceRepository extends JpaRepository<PriceEntity, Long> {

	@Query("SELECT p FROM PriceEntity p WHERE p.productId = :productId AND p.brand.brandId = :brandId AND p.startDate > :startDate") 
	public Collection<PriceEntity> findByPrice(String productId, Long brandId, Date startDate);
}
