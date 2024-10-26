package vn.edu.iuh.fit.on_gk.repositori;

import vn.edu.iuh.fit.on_gk.entity.Xe;

import java.util.List;

public interface XeRepositori {

    List<Xe> getDsXe();
    Xe findByID(int id);
    List<Xe>  findByTenXe(String name);
    Xe findByGiaXe(double gia);
    boolean addXe(Xe xe);
    boolean updateXe(Xe xe);
    boolean deleteXe(Xe xe);

}
