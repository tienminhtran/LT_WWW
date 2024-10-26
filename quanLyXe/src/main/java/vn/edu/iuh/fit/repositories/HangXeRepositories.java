/**
 * @ (#) HangXeRepositories.java      10/24/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.entities.HangXe;

import java.util.List;


public interface HangXeRepositories {
    public HangXe findById(long id);

    public  HangXe findByTenHangXe(String hangXe);
    public List<HangXe> findAll();

}
