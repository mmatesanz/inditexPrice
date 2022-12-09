package com.marianoMatesanz.domain.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "BRANDS")
@SequenceGenerator(name = "seqBrand", sequenceName = "SEQ_BRAND_ID")
public class Brand {
    /**
     * Unique Identifier for the Brand
     */
    @Id    
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqBrand")
    @Column(name = "BRAND_ID")
    private Long brandId;
    
    /**
     * Brand´s Name
     */
    @Column(name = "NAME")
    private String name;


  


   
}
