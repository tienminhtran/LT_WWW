/*
 * @ {#} ProductBean.java   1.0     02/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.week03_lab.backend.business;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import vn.edu.iuh.fit.week03_lab.backend.dtos.ProductDTO;
import vn.edu.iuh.fit.week03_lab.backend.repositories.ProductPriceRepository;
import vn.edu.iuh.fit.week03_lab.backend.repositories.ProductRepository;
import vn.edu.iuh.fit.week03_lab.backend.repositories.entities.Product;
import vn.edu.iuh.fit.week03_lab.backend.repositories.entities.ProductPrice;

import java.util.ArrayList;
import java.util.List;


@Stateless
public class ProductBean implements ProductBeanRemote {
    @Inject
    private ProductRepository productRepository;
    @Inject
    private ProductPriceRepository productPriceRepository;

    @Override
    public void add(Product product) {
        productRepository.add(product);
    }

    @Override
    public List<ProductDTO> getAll() {
        List<Product> products = productRepository.getAll();
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Product product : products) {
            ProductPrice productPrice = productPriceRepository.findActivePriceByProductId(product.getId());
            double price = (productPrice != null) ? productPrice.getValue() : 0.0;
            ProductDTO productDTO = new ProductDTO(
                    product.getId(),
                    product.getName(),
                    product.getDescription(),
                    product.getImgPath(),
                    price
            );
            productDTOS.add(productDTO);
        }
        return productDTOS;
    }


    @Override
    public ProductDTO getById(int id) {
        Product product = productRepository.getById(id);
        ProductPrice productPrice = productPriceRepository.findActivePriceByProductId(product.getId());
        double price = (productPrice != null) ? productPrice.getValue() : 0.0;
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getImgPath(),
                price
        );
    }
}
