/*
 * @ {#} HangXeService.java   1.0     24/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.entities.HangXe;

import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   24/10/2024
 * @version:    1.0
 */
public interface HangXeService {
    List<HangXe> getDsHangXe();
    HangXe findByID(int id);
}
