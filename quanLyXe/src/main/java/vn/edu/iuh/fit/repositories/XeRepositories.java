/**
 * @ (#) XeRepositories.java      10/24/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.entities.Xe;

import java.util.List;


public interface XeRepositories {
    public List<Xe> findAll();
    public List<Xe> findByTenXe(String tenXe);
    public Xe findById(long id);
    public boolean save(Xe xe);
    public boolean update(Xe xe);
    public boolean delete(long id);
}
