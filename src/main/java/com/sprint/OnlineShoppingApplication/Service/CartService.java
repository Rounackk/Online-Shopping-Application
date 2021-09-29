package com.sprint.OnlineShoppingApplication.Service;

import com.sprint.OnlineShoppingApplication.model.Cart;
import com.sprint.OnlineShoppingApplication.model.Product;

public interface CartService {
    public Cart addProductToCart(Cart cart, Product p, int quantity);
    public Cart removeProductFromCart(Cart cart , Product p);
    public Cart updateProductQuantity(Cart cart, Product p, int quantity);
    public Cart removeAllProducts(Cart cart);
    public Cart viewAllProduct(Cart cart);
}
