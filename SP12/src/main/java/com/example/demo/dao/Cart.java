package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Product;
import com.example.demo.model.ProductInCart;

import org.springframework.stereotype.Repository;

@Repository
public class Cart {
    private List<ProductInCart> productInCartList = new ArrayList<>();

    public List<ProductInCart> getProductInCartList() {
        return this.productInCartList;
    }

    public void setProductInCartList(List<ProductInCart> productInCartList) {
        this.productInCartList = productInCartList;
    }

    public void addProductToCart(Product product) {
        ProductInCart newProduct = new ProductInCart(product.getProduct_id(), product.getProduct_name(), product.getPrice(), 1, 1);
        productInCartList.add(newProduct);
    }

    public Optional<ProductInCart> getProductInCartById(String product_id) {
        return productInCartList.stream()
                .filter(productInCart -> productInCart.getProduct_id().equals(product_id))
                .findFirst();
    }

    public int removeProductFromCart(String product_id) {
        Optional<ProductInCart> productInCart = getProductInCartById(product_id);
        if (productInCart.isEmpty()) {
            return 0;
        }
        productInCartList.remove(productInCart.get());
        return 1;
    }

    public int updateProductQuantityInCart(String product_id, ProductInCart productInCart) {
        Optional<ProductInCart> tempProduct = getProductInCartById(product_id);
        return tempProduct
                .map(product -> {
                    int indexOfProductInCartToUpdate = productInCartList.indexOf(product);
                    if (indexOfProductInCartToUpdate >= 0) {
                        productInCartList.set(indexOfProductInCartToUpdate, new ProductInCart(product_id, tempProduct.get().getProduct_name(), tempProduct.get().getPrice(), productInCart.getQuantity(),productInCart.getStatus()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
