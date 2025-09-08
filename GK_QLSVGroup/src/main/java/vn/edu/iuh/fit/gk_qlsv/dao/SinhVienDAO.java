package vn.edu.iuh.fit.gk_qlsv.dao;

import vn.edu.iuh.fit.gk_qlsv.model.SinhVien;
import vn.edu.iuh.fit.gk_qlsv.model.Lop;
import vn.edu.iuh.fit.gk_qlsv.utlis.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SinhVienDAO {

    /** Lấy danh sách tất cả sinh viên */
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

    /** Thêm sinh viên mới */
    public boolean insert(SinhVien sv) {
        String sql = "INSERT INTO SINHVIEN (mssv, hoten, ngaysinh, diem, malop) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, sv.getMssv());
            ps.setString(2, sv.getHoten());
            ps.setDate(3, new java.sql.Date(sv.getNgaysinh().getTime()));
            ps.setDouble(4, sv.getDiem());
            ps.setString(5, sv.getLop().getMalop());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /** Cập nhật thông tin sinh viên */
    public boolean update(SinhVien sv) {
        String sql = "UPDATE SINHVIEN SET hoten = ?, ngaysinh = ?, diem = ?, malop = ? WHERE mssv = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, sv.getHoten());
            ps.setDate(2, new java.sql.Date(sv.getNgaysinh().getTime()));
            ps.setDouble(3, sv.getDiem());
            ps.setString(4, sv.getLop().getMalop());
            ps.setString(5, sv.getMssv());

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

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
