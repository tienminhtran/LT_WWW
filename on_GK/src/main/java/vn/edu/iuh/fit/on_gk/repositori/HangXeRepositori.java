package vn.edu.iuh.fit.on_gk.repositori;

import vn.edu.iuh.fit.on_gk.entity.HangXe;

import java.util.List;

public interface HangXeRepositori {

    List<HangXe> getDsHangXe();
    HangXe findByID(int id);
}
