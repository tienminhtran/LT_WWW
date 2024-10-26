/*
 * @ {#} HangXeServiceImpl.java   1.0     24/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.services.impl;

import vn.edu.iuh.fit.entities.HangXe;
import vn.edu.iuh.fit.repositories.HangXeDAO;
import vn.edu.iuh.fit.repositories.impl.HangXeDAOImpl;
import vn.edu.iuh.fit.services.HangXeService;

import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   24/10/2024
 * @version:    1.0
 */
public class HangXeServiceImpl implements HangXeService {
    private HangXeDAO hangXeDAO;

    public HangXeServiceImpl() {
        this.hangXeDAO = new HangXeDAOImpl();
    }

    @Override
    public List<HangXe> getDsHangXe() {
        return hangXeDAO.getDsHangXe();
    }

    @Override
    public HangXe findByID(int id) {
        return hangXeDAO.findByID(id);
    }
}
