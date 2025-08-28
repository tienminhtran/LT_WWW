/**
 * @ (#) QuanLyLoaiThuocDAO.java      8/28/2025
 * <p>
 * Copyright (c) 2025 IUH. All rights reserved
 */

package vn.edu.iuh.fit.thuoc_tien.dao;

import vn.edu.iuh.fit.thuoc_tien.model.LoaiThuoc;
import vn.edu.iuh.fit.thuoc_tien.model.Thuoc;
import vn.edu.iuh.fit.thuoc_tien.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * @description:
 * @author: Tien Minh Tran
 * @date: 8/28/2025
 */
public class QuanLyLoaiThuocDAO {
    // Danh sách loại thuốc
    public List<LoaiThuoc> findAll() throws SQLException, ClassNotFoundException {
        List<LoaiThuoc> list = new ArrayList<>();
        String sql = "SELECT MALOAI, TENLOAI FROM LOAITHUOC";

        try (Connection con = DBUtil.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                int maLoai = rs.getInt("MALOAI");
                String tenLoai = rs.getString("TENLOAI");
                LoaiThuoc loaiThuoc = new LoaiThuoc(maLoai, tenLoai);
                list.add(loaiThuoc);  // thêm vào danh sách
            }
        }
        return list;
    }
}