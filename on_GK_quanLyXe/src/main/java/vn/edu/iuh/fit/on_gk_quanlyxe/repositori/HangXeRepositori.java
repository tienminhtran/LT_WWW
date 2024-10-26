package vn.edu.iuh.fit.on_gk_quanlyxe.repositori;

import vn.edu.iuh.fit.on_gk_quanlyxe.entity.HangXe;

import java.util.List;

public interface HangXeRepositori {

    public List<HangXe> findTenHangXe(String tenHangXe);

    public HangXe findHangXeById(String id);

}
