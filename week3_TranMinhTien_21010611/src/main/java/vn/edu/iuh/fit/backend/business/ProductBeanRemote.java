/*
 * @ {#} ProductBeanRemote.java   1.0     02/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.backend.business;

import jakarta.ejb.Local;
import jakarta.ejb.Remote;
import vn.edu.iuh.fit.backend.dtos.ProductDTO;
import vn.edu.iuh.fit.backend.repositories.entities.Product;

import java.util.List;


//@Remote
@Local
public interface ProductBeanRemote {
    void add (Product product);
    List<ProductDTO> getAll();
    ProductDTO getById(int id);
}
