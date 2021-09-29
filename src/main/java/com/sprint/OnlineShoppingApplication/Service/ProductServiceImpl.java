package com.sprint.OnlineShoppingApplication.Service;

import com.sprint.OnlineShoppingApplication.Dto.ProductDto;
import com.sprint.OnlineShoppingApplication.Exception.ProductNotFoundException;
import com.sprint.OnlineShoppingApplication.Repository.ProductRepository;
import com.sprint.OnlineShoppingApplication.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Product addProduct(ProductDto prod) {
        Product product = new Product();
        product.setProductName(prod.getProductName());
        product.setColor(prod.getColor());
        product.setPrice(prod.getPrice());
        product.setDimension(prod.getDimension());
        product.setManufacturer(prod.getManufacturer());
        product.setQuantity(prod.getQuantity());
        product.setSpecification(prod.getSpecification());

        Product product1 = productRepository.save(product);
        return product1;
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public Integer removeProduct(Integer productId) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isPresent())
        {
            productRepository.deleteById(productId);
        }
        else
            throw new ProductNotFoundException();

        return productId;
    }

    @Override
    public Product viewProduct(Integer productId) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isPresent())
        {
            return optionalProduct.get();
        }
        else
            throw new ProductNotFoundException();

    }

    @Override
    public List<Product> viewProductByCategory(String categotyName) {
        return null;
    }
}
