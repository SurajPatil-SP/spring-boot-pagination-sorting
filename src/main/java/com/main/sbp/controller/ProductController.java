package com.main.sbp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.sbp.dto.ApiResponse;
import com.main.sbp.entity.Product;
import com.main.sbp.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping
	private ApiResponse<List<Product>> getProducts() {
		List<Product> allProducts = service.findAllProducts();
		return new ApiResponse<>(allProducts.size(), allProducts);
	}

	@GetMapping("/{field}")
	private ApiResponse<List<Product>> getProductsWithSort(@PathVariable String field) {
		List<Product> allProducts = service.findProductsWithSorting(field);
		return new ApiResponse<>(allProducts.size(), allProducts);
	}

	@GetMapping("/pagination/{offset}/{pageSize}")
	private ApiResponse<Page<Product>> getProductsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
		Page<Product> productsWithPagination = service.findProductsWithPagination(offset, pageSize);
		return new ApiResponse<>(productsWithPagination.getSize(), productsWithPagination);
	}

	@GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
	private ApiResponse<Page<Product>> getProductsWithPaginationAndSort(@PathVariable int offset,
			@PathVariable int pageSize, @PathVariable String field) {
		Page<Product> productsWithPagination = service.findProductsWithPaginationAndSorting(offset, pageSize, field);
		return new ApiResponse<>(productsWithPagination.getSize(), productsWithPagination);
	}
}
