/*
 * @ {#} XeDAO.java   1.0     24/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.entities.Xe;

import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   24/10/2024
 * @version:    1.0
 */
public interface XeDAO {
    List<Xe> getDsXe();
    Xe findByID(int id);
    Xe findByTenXe(String name);
    Xe findByGiaXe(double gia);
    Xe addXe(Xe xe);
    Xe updateXe(Xe xe);
    Xe deleteXe(Xe xe);
}
