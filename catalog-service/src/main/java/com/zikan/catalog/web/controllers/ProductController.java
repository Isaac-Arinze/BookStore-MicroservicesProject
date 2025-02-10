package com.zikan.catalog.web.controllers;

import com.zikan.catalog.domain.PagedResult;
import com.zikan.catalog.domain.Product;
import com.zikan.catalog.domain.ProductNotFoundException;
import com.zikan.catalog.domain.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
class ProductController {

    private final ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    PagedResult<Product> getProduct(@RequestParam(name = "page", defaultValue = "1") int pageNo) {
        return productService.getProducts(pageNo);
    }

    @GetMapping("{code}")
    ResponseEntity<Product> getProductByCode(@PathVariable String code) {
        sleep();
        return productService
                .getProductsByCode(code)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> ProductNotFoundException.forCode(code));
    }

    void sleep(){
        try{
            Thread.sleep(6000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
