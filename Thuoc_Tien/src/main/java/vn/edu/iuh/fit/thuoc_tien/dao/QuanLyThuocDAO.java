/**
 * @ (#) QuanLyThuocDAO.java      8/28/2025
 * <p>
 * Copyright (c) 2025 IUH. All rights reserved
 */

package vn.edu.iuh.fit.thuoc_tien.dao;

/*
 * @description:
 * @author: Tien Minh Tran
 * @date: 8/28/2025
 */


import vn.edu.iuh.fit.thuoc_tien.model.Thuoc;
import vn.edu.iuh.fit.thuoc_tien.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuanLyThuocDAO {

    //danh sách thuoc
    public List<Thuoc> findAll() throws SQLException, ClassNotFoundException {
        List<Thuoc> list = new ArrayList<>();
        String sql = "SELECT MATHUOC, TENTHUOC, GIA, NAMNX, MALOAI FROM THUOC";

        try (Connection con = DBUtil.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Thuoc t = new Thuoc(
                        rs.getInt("MATHUOC"),
                        rs.getString("TENTHUOC"),
                        rs.getBigDecimal("GIA"),
                        rs.getInt("NAMNX"),
                        rs.getInt("MALOAI")
                );
                list.add(t);
            }
        }
        return list;
    }

    /**
     * Thêm thuốc
     * @param t
     * @throws Exception
     */
    public void insert(Thuoc t) throws Exception {
        String sql = "INSERT INTO THUOC(TENTHUOC, GIA, NAMNX, MALOAI) VALUES (?,?,?,?)";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, t.getTenThuoc());
            ps.setBigDecimal(2, t.getGia());
            ps.setInt(3, t.getNamNX());
            ps.setInt(4, t.getMaLoai());
            ps.executeUpdate();
        }
    }


    /**
     * Lọc thuốc theo loại
     * @param maLoai
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Thuoc> findByLoai(int maLoai) throws SQLException, ClassNotFoundException {
        List<Thuoc> list = new ArrayList<>();
        String sql = "SELECT MATHUOC, TENTHUOC, GIA, NAMNX, MALOAI FROM THUOC WHERE MALOAI=?";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, maLoai);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Thuoc t = new Thuoc(
                            rs.getInt("MATHUOC"),
                            rs.getString("TENTHUOC"),
                            rs.getBigDecimal("GIA"),
                            rs.getInt("NAMNX"),
                            rs.getInt("MALOAI")
                    );
                    list.add(t);
                }
            }
        }
        return list;
    }

}
