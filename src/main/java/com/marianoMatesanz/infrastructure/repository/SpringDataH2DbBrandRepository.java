package com.marianoMatesanz.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataH2DbBrandRepository extends JpaRepository<BrandEntity, Long> {

}
