package com.rsn.pagination.pagination_with_sorting.service;

import com.rsn.pagination.pagination_with_sorting.model.Product;
import com.rsn.pagination.pagination_with_sorting.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;


    //    @PostConstruct
//    public void intiDB() {
//        List<Product> products = IntStream.rangeClosed(1, 200).
//                mapToObj(i -> new Product("product" + i, new Random().nextInt(100), new Random().nextInt(50000))).
//                collect(Collectors.toList());
//        productRepo.saveAll(products);
//    }
    public List<Product> getAllData() {
        return productRepo.findAll();
    }

    public List<Product> findProductsWithSorting(String field) {
        return productRepo.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    public Page<Product> findByProductsWithPagination(int offset, int pageSize) {
        Page<Product> products = productRepo.findAll(PageRequest.of(offset, pageSize));
        return products;
    }

    public Page<Product> findByProductsWithPaginationAndSorting(int offset, int pageSize, String field) {
        Page<Product> products = productRepo.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return products;
    }

}
