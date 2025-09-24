/**
 * @ (#) SinhVienDao.java      9/13/2025
 * <p>
 * Copyright (c) 2025 IUH. All rights reserved
 */

package vn.edu.iuh.fit.demoqlsv.dao;

import vn.edu.iuh.fit.demoqlsv.model.Lop;
import vn.edu.iuh.fit.demoqlsv.model.SinhVien;
import vn.edu.iuh.fit.demoqlsv.utlis.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
 * @description:
 * @author: Tien Minh Tran
 * @date: 9/13/2025
 */
public class SinhVienDao {

    public List<SinhVien> findAll(){
        List<SinhVien> list = new ArrayList<>();

            String sql = "SELECT sv.*, l.malop, l.tenlop " +
                    "FROM SINHVIEN sv " +
                    "JOIN LOP l ON sv.malop = l.malop";
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                Lop lop = new Lop(rs.getString("malop"), rs.getString("tenlop"));
                list.add(new SinhVien(
                        rs.getString("mssv"),
                        rs.getString("hoten"),
                        rs.getString("ngaysinh"),
                        rs.getDouble("diem"),
                        lop
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return list;
    }

    public boolean insert(SinhVien sv){
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement("INSERT INTO SINHVIEN (mssv, hoten, ngaysinh, diem, malop) VALUES (?, ?, ?, ?, ?)")
        ){
            ps.setString(1, sv.getMssv());
            ps.setString(2, sv.getHoten());
            ps.setString(3, sv.getNgaysinh());
            ps.setDouble(4, sv.getDiem());
            ps.setString(5, sv.getLop().getMalop());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /** Xóa sinh viên theo MSSV */
    public boolean delete(String mssv) {
        String sql = "DELETE FROM SINHVIEN WHERE mssv = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, mssv);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    /** Cập nhật thông tin sinh viên */
    public boolean update(SinhVien sv) {
        String sql = "UPDATE SINHVIEN SET hoten = ?, ngaysinh = ?, diem = ?, malop = ? WHERE mssv = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, sv.getHoten());
            ps.setString(2, sv.getNgaysinh());
            ps.setDouble(3, sv.getDiem());
            ps.setString(4, sv.getLop().getMalop());
            ps.setString(5, sv.getMssv());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /** Tìm sinh viên theo MSSV */
    public SinhVien findById(String mssv) {
        String sql = "SELECT s.*, l.malop, l.tenlop " +
                "FROM SINHVIEN s JOIN LOP l ON s.malop = l.malop WHERE s.mssv=?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, mssv);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                return new SinhVien(
                        rs.getString("mssv"),
                        rs.getString("hoten"),
                        rs.getString("ngaysinh"),
                        rs.getDouble("diem"),
                        new Lop(rs.getString("malop"), rs.getString("tenlop"))
                );
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }



    public List<SinhVien> findByName(String name) {
        List<SinhVien> list = new ArrayList<>();
        String sql = "SELECT s.*, l.malop, l.tenlop " +
                "FROM SINHVIEN s JOIN LOP l ON s.malop = l.malop WHERE s.hoten LIKE ?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, "%" + name + "%"); // tìm gần đúng
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SinhVien(
                        rs.getString("mssv"),
                        rs.getString("hoten"),
                        rs.getString("ngaysinh"),
                        rs.getDouble("diem"),
                        new Lop(rs.getString("malop"), rs.getString("tenlop"))
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    /** Tìm danh sách sinh viên có điểm trong khoảng [min, max] */
    public List<SinhVien> findByDiemRange(double min, double max) {
        List<SinhVien> list = new ArrayList<>();
        String sql = "SELECT s.*, l.malop, l.tenlop " +
                "FROM SINHVIEN s JOIN LOP l ON s.malop = l.malop " +
                "WHERE s.diem BETWEEN ? AND ?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setDouble(1, min);
            ps.setDouble(2, max);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SinhVien(
                        rs.getString("mssv"),
                        rs.getString("hoten"),
                        rs.getString("ngaysinh"),
                        rs.getDouble("diem"),
                        new Lop(rs.getString("malop"), rs.getString("tenlop"))
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }









//private static final String BASE_SELECT =
//        "SELECT s.mssv, s.hoten, s.ngaysinh, s.diem, l.malop, l.tenlop " +
//                "FROM SINHVIEN s JOIN LOP l ON s.malop = l.malop ";
//
//    // Lấy tất cả
//    public List<SinhVien> findAll() {
//        List<SinhVien> list = new ArrayList<>();
//        try (Connection conn = DBUtil.getConnection();
//             PreparedStatement ps = conn.prepareStatement(BASE_SELECT);
//             ResultSet rs = ps.executeQuery()) {
//            while (rs.next()) list.add(mapRow(rs));
//        } catch (Exception e) { e.printStackTrace(); }
//        return list;
//    }
//
//    // Thêm
//    public boolean insert(SinhVien sv) {
//        String sql = "INSERT INTO SINHVIEN (mssv, hoten, ngaysinh, diem, malop) VALUES (?, ?, ?, ?, ?)";
//        try (Connection c = DBUtil.getConnection();
//             PreparedStatement ps = c.prepareStatement(sql)) {
//            ps.setString(1, sv.getMssv());
//            ps.setString(2, sv.getHoten());
//            ps.setString(3, sv.getNgaysinh());
//            ps.setDouble(4, sv.getDiem());
//            ps.setString(5, sv.getLop().getMalop());
//            return ps.executeUpdate() > 0;
//        } catch (Exception e) { e.printStackTrace(); return false; }
//    }
//
//    // Xóa
//    public boolean delete(String mssv) {
//        try (Connection conn = DBUtil.getConnection();
//             PreparedStatement ps = conn.prepareStatement("DELETE FROM SINHVIEN WHERE mssv=?")) {
//            ps.setString(1, mssv);
//            return ps.executeUpdate() > 0;
//        } catch (Exception e) { e.printStackTrace(); return false; }
//    }
//
//    // Cập nhật
//    public boolean update(SinhVien sv) {
//        String sql = "UPDATE SINHVIEN SET hoten=?, ngaysinh=?, diem=?, malop=? WHERE mssv=?";
//        try (Connection conn = DBUtil.getConnection();
//             PreparedStatement ps = conn.prepareStatement(sql)) {
//            ps.setString(1, sv.getHoten());
//            ps.setString(2, sv.getNgaysinh());
//            ps.setDouble(3, sv.getDiem());
//            ps.setString(4, sv.getLop().getMalop());
//            ps.setString(5, sv.getMssv());
//            return ps.executeUpdate() > 0;
//        } catch (Exception e) { e.printStackTrace(); return false; }
//    }
//
//    // Tìm theo MSSV
//    public SinhVien findById(String mssv) {
//        try (Connection conn = DBUtil.getConnection();
//             PreparedStatement ps = conn.prepareStatement(BASE_SELECT + "WHERE s.mssv=?")) {
//            ps.setString(1, mssv);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) return mapRow(rs);
//        } catch (Exception e) { e.printStackTrace(); }
//        return null;
//    }
//
//    // Tìm theo tên gần đúng
//    public List<SinhVien> findByName(String name) {
//        List<SinhVien> list = new ArrayList<>();
//        try (Connection conn = DBUtil.getConnection();
//             PreparedStatement ps = conn.prepareStatement(BASE_SELECT + "WHERE s.hoten LIKE ?")) {
//            ps.setString(1, "%" + name + "%");
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) list.add(mapRow(rs));
//        } catch (Exception e) { e.printStackTrace(); }
//        return list;
//    }
//
//    // Tìm theo khoảng điểm
//    public List<SinhVien> findByDiemRange(double min, double max) {
//        List<SinhVien> list = new ArrayList<>();
//        try (Connection conn = DBUtil.getConnection();
//             PreparedStatement ps = conn.prepareStatement(BASE_SELECT + "WHERE s.diem BETWEEN ? AND ?")) {
//            ps.setDouble(1, min);
//            ps.setDouble(2, max);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) list.add(mapRow(rs));
//        } catch (Exception e) { e.printStackTrace(); }
//        return list;
//    }
//
//    // Hàm map dữ liệu từ ResultSet → SinhVien
//    private SinhVien mapRow(ResultSet rs) throws SQLException {
//        return new SinhVien(
//                rs.getString("mssv"),
//                rs.getString("hoten"),
//                rs.getString("ngaysinh"),
//                rs.getDouble("diem"),
//                new Lop(rs.getString("malop"), rs.getString("tenlop"))
//        );
//    }

}