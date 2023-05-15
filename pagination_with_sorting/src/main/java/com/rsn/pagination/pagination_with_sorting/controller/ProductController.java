package com.rsn.pagination.pagination_with_sorting.controller;

import com.rsn.pagination.pagination_with_sorting.dto.APIResponse;
import com.rsn.pagination.pagination_with_sorting.model.Product;
import com.rsn.pagination.pagination_with_sorting.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class ProductController {

    @Autowired
    ProductService productService;


    @PostMapping("/createAccount")
    public ResponseEntity<APIResponse<Product>> createAccount(@RequestBody Product product){
        Product product1 = productService.saveData(product);
        APIResponse<Product> response = new APIResponse(1, createAccount(product1));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/findAllData")
    public APIResponse<List<Product>> findAllData() {
        List<Product> allProd = productService.getAllData();
        return new APIResponse<>(allProd.size(), allProd);
    }

    @GetMapping("/{field}")
    public APIResponse<List<Product>> getProductWithSort(@PathVariable String field) {
        List<Product> allProd = productService.findProductsWithSorting(field);
        return new APIResponse<>(allProd.size(), allProd);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    private APIResponse<Page<Product>> getProductWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        Page<Product> allProd = productService.findByProductsWithPagination(offset, pageSize);
        return new APIResponse<>(allProd.getSize(), allProd);
    }

    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
    private APIResponse<Page<Product>> getProductWithPaginationAndSort(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field) {
        Page<Product> allProd = productService.findByProductsWithPaginationAndSorting(offset, pageSize, field);
        return new APIResponse<>(allProd.getSize(), allProd);
    }
}
