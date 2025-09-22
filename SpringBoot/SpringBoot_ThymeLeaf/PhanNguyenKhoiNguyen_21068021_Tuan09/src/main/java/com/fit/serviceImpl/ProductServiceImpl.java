package com.fit.serviceImpl;

import com.fit.entity.Product;
import com.fit.repository.ProductRepository;
import com.fit.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> searchByKeyWord(String keyword) {
        return productRepository.search(keyword);
    }

    @Override
    public List<Product> searchByDate(Date date) {
        return productRepository.searchByDate(date);
    }

    @Override
    public List<Product> findByCategoryId(int categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    @Override
    public boolean deleteProduct(int id) {
       if(productRepository.existsById(id)){
           productRepository.deleteById(id);
           return true;
         }else {
              return false;
       }
    }

    @Override
    public boolean updateProduct(Product product) {
        if(productRepository.existsById(product.getId())){  //Nếu tồn tại product trong database
            productRepository.save(product);
            return true;
        }else {
            return false;
        }
    }


    @Override
    public Page<Product> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize,
                sortDirection.equalsIgnoreCase("asc")
                        ? Sort.by(sortField).ascending()
                        : Sort.by(sortField).descending());

        // Gọi phương thức của ProductRepository để lấy danh sách phân trang
        return productRepository.findAll(pageable);
    }
}
