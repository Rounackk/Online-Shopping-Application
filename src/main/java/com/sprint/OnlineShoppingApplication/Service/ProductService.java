package com.sprint.OnlineShoppingApplication.Service;

import com.sprint.OnlineShoppingApplication.Dto.ProductDto;
import com.sprint.OnlineShoppingApplication.Exception.ProductNotFoundException;
import com.sprint.OnlineShoppingApplication.model.Product;

import java.util.List;


public interface ProductService {

    public Product addProduct(ProductDto prod);

    public Product updateProduct(Product product);
    public Integer removeProduct(Integer productId) throws ProductNotFoundException;
    public Product viewProduct(Integer productId) throws ProductNotFoundException;
    public List<Product> viewProductByCategory(String categotyName);
}
