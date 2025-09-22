package com.fit.service;

import com.fit.entity.Product;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts();
    public Product getProductById(int id);
    public Product saveProduct(Product product);

    public List<Product> searchByKeyWord(String keyword);
    public List<Product> searchByDate(Date date);

    public List<Product> findByCategoryId(int categoryId);


    public boolean deleteProduct(int id);
    public boolean updateProduct(Product product);
    public Page<Product> findPaginated(int pageNo, int pageSize,String sortField, String sortDirection);
}
