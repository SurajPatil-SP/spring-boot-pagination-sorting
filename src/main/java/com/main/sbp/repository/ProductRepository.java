package com.main.sbp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.sbp.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
