package vn.edu.iuh.fit.on_gk.services.impl;

import vn.edu.iuh.fit.on_gk.entity.HangXe;
import vn.edu.iuh.fit.on_gk.repositori.HangXeRepositori;
import vn.edu.iuh.fit.on_gk.repositori.XeRepositori;
import vn.edu.iuh.fit.on_gk.repositori.impl.HangXeRepositoriImpl;
import vn.edu.iuh.fit.on_gk.repositori.impl.XeRepositoriImpl;
import vn.edu.iuh.fit.on_gk.services.HangXeService;

import java.util.List;

public class HangXeServiceImpl implements HangXeService {
    private final HangXeRepositori hangXeRepositori;


    public HangXeServiceImpl() {
        hangXeRepositori = new HangXeRepositoriImpl();

    }



    @Override
    public List<HangXe> getDsHangXe() {
        return hangXeRepositori.getDsHangXe();
    }

    @Override
    public HangXe findByID(int id) {
        return hangXeRepositori.findByID(id);
    }
}
