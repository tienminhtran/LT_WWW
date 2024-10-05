package vn.edu.iuh.fit.backend.business;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import vn.edu.iuh.fit.backend.repositories.entities.Product;

import java.util.List;

@Stateless
public class ProductBean implements ProductBeanRemote{

    @PersistenceContext(unitName = "JPA_MariaDB")
    private EntityManager em;
    @Override
    public Product addProduct(Product product) {
         em.persist(product);

        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return em.createQuery("select p from Product p").getResultList();
    }

    @Override
    public Product getProductById(int id) {
        return em.find(Product.class, id);
    }
}
