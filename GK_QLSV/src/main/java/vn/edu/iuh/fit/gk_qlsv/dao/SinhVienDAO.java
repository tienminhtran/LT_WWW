/**
 * @ (#) SinhVienDAO.java      9/8/2025
 * <p>
 * Copyright (c) 2025 IUH. All rights reserved
 */

package vn.edu.iuh.fit.gk_qlsv.dao;

import vn.edu.iuh.fit.gk_qlsv.model.SinhVien;
import vn.edu.iuh.fit.gk_qlsv.model.Lop;
import vn.edu.iuh.fit.gk_qlsv.utlis.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SinhVienDAO {

    public List<SinhVien> findAll() {
        List<SinhVien> list = new ArrayList<>();
        String sql = "SELECT s.mssv, s.hoten, s.ngaysinh, s.diem, s.malop, l.tenlop " +
                "FROM SINHVIEN s JOIN LOP l ON s.malop = l.malop";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Lop lop = new Lop(rs.getString("malop"), rs.getString("tenlop"));
                SinhVien sv = new SinhVien(
                        rs.getString("mssv"),
                        rs.getString("hoten"),
                        rs.getDate("ngaysinh"),
                        rs.getDouble("diem"),
                        lop
                );
                list.add(sv);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    // --- Phương thức thêm sinh viên ---
    public void insert(SinhVien sv) throws SQLException {
        String sql = "INSERT INTO SINHVIEN (mssv, hoten, ngaysinh, diem, malop) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, sv.getMssv());
            ps.setString(2, sv.getHoten());
            ps.setDate(3, new Date(sv.getNgaysinh().getTime())); // convert java.util.Date -> java.sql.Date
            ps.setDouble(4, sv.getDiem());
            ps.setString(5, sv.getLop().getMalop());

            ps.executeUpdate();
        }
    }

    // --- Tìm sinh viên có điểm trong khoảng ---
    public List<SinhVien> findByDiem(double minDiem, double maxDiem) {
        List<SinhVien> list = new ArrayList<>();
        String sql = "SELECT s.mssv, s.hoten, s.ngaysinh, s.diem, s.malop, l.tenlop " +
                "FROM SINHVIEN s JOIN LOP l ON s.malop = l.malop " +
                "WHERE s.diem BETWEEN ? AND ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, minDiem);
            ps.setDouble(2, maxDiem);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Lop lop = new Lop(rs.getString("malop"), rs.getString("tenlop"));
                    SinhVien sv = new SinhVien(
                            rs.getString("mssv"),
                            rs.getString("hoten"),
                            rs.getDate("ngaysinh"),
                            rs.getDouble("diem"),
                            lop
                    );
                    list.add(sv);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void deleteByMssv(String mssv) throws SQLException {
        String sql = "DELETE FROM SINHVIEN WHERE mssv = ?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, mssv);
            ps.executeUpdate();
        }
    }

    public void update(SinhVien sv) throws SQLException {
        String sql = "UPDATE SINHVIEN SET hoten=?, ngaysinh=?, diem=?, malop=? WHERE mssv=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, sv.getHoten());
            ps.setDate(2, (Date) sv.getNgaysinh());
            ps.setDouble(3, sv.getDiem());
            ps.setString(4, sv.getLop().getMalop());
            ps.setString(5, sv.getMssv());
            ps.executeUpdate();
        }
    }

    public SinhVien findByMssv(String mssv) {
        String sql = "SELECT s.mssv, s.hoten, s.ngaysinh, s.diem, s.malop, l.tenlop " +
                "FROM SINHVIEN s JOIN LOP l ON s.malop = l.malop WHERE s.mssv = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, mssv);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Lop lop = new Lop(rs.getString("malop"), rs.getString("tenlop"));
                    return new SinhVien(rs.getString("mssv"),
                            rs.getString("hoten"),
                            rs.getDate("ngaysinh"),
                            rs.getDouble("diem"),
                            lop);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
