package com.Luis.kenway.RETOC42.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.Luis.kenway.RETOC42.model.Products;
import com.Luis.kenway.RETOC42.repository.ProductsRepository;

@Service
public class ProductService {
    @Autowired
    private ProductsRepository productsRepository;

    public List<Products> getAll() {
        return productsRepository.getAll();
    }

    public Optional<Products> getProducts(String reference){
        return productsRepository.getProducts(reference);
    }

    public Products create(Products product) {
        if (product.getReference() != null) {
            return productsRepository.create(product);
        }
        return product;
    }

    public Products update(Products product) {
        if (product.getReference() != null) {
            Optional<Products> productDb = productsRepository.getProducts(product.getReference());
            if (productDb.isPresent()) {
                if (product.getCategory() != null) {
                    productDb.get().setCategory(product.getCategory());
                }
                if (product.getDescription() != null) {
                    productDb.get().setDescription(product.getDescription());
                }
                if (product.getPrice() != 0.0) {
                    productDb.get().setPrice(product.getPrice());
                }
                if (product.getQuantity() != 0) {
                    productDb.get().setQuantity(product.getQuantity());
                }
                if (product.getPhotography() != null) {
                    productDb.get().setPhotography(product.getPhotography());
                }
                productDb.get().setAvailability(product.isAvailability());
                productsRepository.update(productDb.get());
                return productDb.get();
            }
        }
        return product;
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getProducts(reference).map(products -> {
            productsRepository.delete(products);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
