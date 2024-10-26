package vn.edu.iuh.fit.on_gk.services;

import vn.edu.iuh.fit.on_gk.entity.Xe;

import java.util.List;

public interface XeService {
    List<Xe> getDsXe();
    Xe findByID(int id);
    List<Xe> findByTenXe(String name);
    Xe findByGiaXe(double gia);
    boolean addXe(Xe xe);
    boolean updateXe(Xe xe);
    boolean deleteXe(Xe xe);
}
