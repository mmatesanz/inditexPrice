package com.marianoMatesanz.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.marianoMatesanz.DomainLayerApplication;
import com.marianoMatesanz.domain.repository.PriceRepository;
import com.marianoMatesanz.domain.service.DomainPriceService;
import com.marianoMatesanz.domain.service.PriceService;

@Configuration
@ComponentScan(basePackageClasses = DomainLayerApplication.class)
public class BeanConfiguration {

    @Bean
    PriceService orderService(final PriceRepository priceRepository) {
        return new DomainPriceService(priceRepository);
    }
}