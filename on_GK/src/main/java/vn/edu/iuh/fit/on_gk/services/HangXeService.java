package vn.edu.iuh.fit.on_gk.services;

import vn.edu.iuh.fit.on_gk.entity.HangXe;

import java.util.List;

public interface HangXeService {
    List<HangXe> getDsHangXe();
    HangXe findByID(int id);
}
