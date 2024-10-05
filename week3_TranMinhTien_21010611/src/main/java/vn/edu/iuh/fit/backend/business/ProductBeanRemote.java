package vn.edu.iuh.fit.backend.business;

import jakarta.ejb.Remote;
import vn.edu.iuh.fit.backend.repositories.entities.Product;

import java.util.List;

@Remote
public interface ProductBeanRemote {
    Product addProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(int id);
}
