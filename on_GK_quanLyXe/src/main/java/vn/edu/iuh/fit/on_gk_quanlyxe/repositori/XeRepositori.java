package vn.edu.iuh.fit.on_gk_quanlyxe.repositori;

import vn.edu.iuh.fit.on_gk_quanlyxe.entity.Xe;

import java.util.List;

public interface XeRepositori {

    public List<Xe> getAlXe();
    public List<Xe> fineTenXe(String tenXe);

}
