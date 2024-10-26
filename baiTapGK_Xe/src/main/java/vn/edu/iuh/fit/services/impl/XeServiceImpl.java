/*
 * @ {#} XeServiceImpl.java   1.0     24/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.services.impl;

import vn.edu.iuh.fit.entities.Xe;
import vn.edu.iuh.fit.repositories.XeDAO;
import vn.edu.iuh.fit.repositories.impl.XeDAOImpl;
import vn.edu.iuh.fit.services.XeService;

import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   24/10/2024
 * @version:    1.0
 */
public class XeServiceImpl implements XeService {
    private XeDAO xeDAO;

    public XeServiceImpl() {
        this.xeDAO = new XeDAOImpl();
    }

    @Override
    public List<Xe> getDsXe() {
        return xeDAO.getDsXe();
    }

    @Override
    public Xe findByID(int id) {
        return xeDAO.findByID(id);
    }

    @Override
    public Xe findByTenXe(String name) {
        return xeDAO.findByTenXe(name);
    }

    @Override
    public Xe findByGiaXe(double gia) {
        return xeDAO.findByGiaXe(gia);
    }

    @Override
    public Xe addXe(Xe xe) {
        return xeDAO.addXe(xe);
    }

    @Override
    public Xe updateXe(Xe xe) {
        return xeDAO.updateXe(xe);
    }

    @Override
    public Xe deleteXe(Xe xe) {
        return xeDAO.deleteXe(xe);
    }

    public static void main(String[] args) {
        XeService xeService = new XeServiceImpl();
        List<Xe> xeList = xeService.getDsXe();
        for (Xe xe : xeList) {
            System.out.println(xe.getTenxe());
        }
    }
}
