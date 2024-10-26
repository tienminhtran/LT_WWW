package vn.edu.iuh.fit.on_gk.services.impl;

import vn.edu.iuh.fit.on_gk.entity.HangXe;
import vn.edu.iuh.fit.on_gk.entity.Xe;
import vn.edu.iuh.fit.on_gk.repositori.HangXeRepositori;
import vn.edu.iuh.fit.on_gk.repositori.XeRepositori;
import vn.edu.iuh.fit.on_gk.repositori.impl.HangXeRepositoriImpl;
import vn.edu.iuh.fit.on_gk.repositori.impl.XeRepositoriImpl;
import vn.edu.iuh.fit.on_gk.services.HangXeService;
import vn.edu.iuh.fit.on_gk.services.XeService;

import java.util.ArrayList;
import java.util.List;

public class XeServiceImpl implements XeService {

    private final XeRepositori xeRepositori;


    public XeServiceImpl() {
        xeRepositori = new XeRepositoriImpl();

    }

    @Override
    public List<Xe> getDsXe() {
        return xeRepositori.getDsXe();
    }

    @Override
    public Xe findByID(int id) {
        return xeRepositori.findByID(id);
    }

    @Override
    public  List<Xe>  findByTenXe(String name) {
        return xeRepositori.findByTenXe(name);
    }

    @Override
    public Xe findByGiaXe(double gia) {
        return xeRepositori.findByGiaXe(gia);
    }

    @Override
    public boolean addXe(Xe xe) {
        HangXeService hangXeService = new HangXeServiceImpl();
        HangXe hangXe = hangXeService.findByID(xe.getMaHangXe().getMaHangXe());
        xe.setMaHangXe(hangXe);
        return xeRepositori.addXe(xe);
    }

    @Override
    public boolean updateXe(Xe xe){
        HangXeService hangXeService = new HangXeServiceImpl();
        HangXe hangXe = hangXeService.findByID(xe.getMaHangXe().getMaHangXe());
        xe.setMaHangXe(hangXe);
        return xeRepositori.updateXe(xe);
    }

    @Override
    public boolean deleteXe(Xe xe) {
        return xeRepositori.deleteXe(xe);
    }
}
