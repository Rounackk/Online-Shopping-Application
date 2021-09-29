package com.sprint.OnlineShoppingApplication.Controller;

import com.sprint.OnlineShoppingApplication.Dto.ProductDto;
import com.sprint.OnlineShoppingApplication.Exception.ProductNotFoundException;
import com.sprint.OnlineShoppingApplication.Service.ProductService;
import com.sprint.OnlineShoppingApplication.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/addproduct")
    public ResponseEntity<Product> addProduct(@RequestBody ProductDto productDto){
        Product product2 = productService.addProduct(productDto);
        return new ResponseEntity<>(product2, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteproduct/{productId}")
    public ResponseEntity<Void> removeProduct(@PathVariable int productId) throws ProductNotFoundException {
        productService.removeProduct(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/viewproductbyid/{productId}")
    public Product viewProduct(@PathVariable int productId) throws ProductNotFoundException {
        return productService.viewProduct(productId);
    }
}
