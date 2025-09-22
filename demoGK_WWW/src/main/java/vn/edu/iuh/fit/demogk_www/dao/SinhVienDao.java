/**
 * @ (#) SinhVienDao.java      9/14/2025
 * <p>
 * Copyright (c) 2025 IUH. All rights reserved
 */

package vn.edu.iuh.fit.demogk_www.dao;

import vn.edu.iuh.fit.demogk_www.model.Lop;
import vn.edu.iuh.fit.demogk_www.model.SinhVien;
import vn.edu.iuh.fit.demogk_www.utlis.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * @description:
 * @author: Tien Minh Tran
 * @date: 9/14/2025
 */
public class SinhVienDao {
    public List<SinhVien>findAll() {

        List<SinhVien> list = new ArrayList<>();

        String sql = "SELECT sv.mssv, sv.hoten, sv.ngaysinh,sv.diem, l.malop, l.tenlop FROM SINHVIEN sv JOIN LOP l ON sv.malop = l.malop";

        try(
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()){

            while(rs.next()){
                Lop lop = new Lop(rs.getString("malop"), rs.getString("tenlop"));

                list.add(new SinhVien(
                        rs.getString("mssv"),
                        rs.getString("hoten"),
                        rs.getString("ngaysinh"),
                        rs.getDouble("diem"),
                        lop
                ));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return list;

    }

    public boolean insert(SinhVien sv){
        String sql = "INSERT INTO SINHVIEN (mssv, hoten, ngaysinh, diem, malop) VALUES (?, ?, ?, ?, ?)";
        try( Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)){
            ps.setString(1, sv.getMssv());
            ps.setString(2, sv.getHoten());
            ps.setString(3, sv.getNgaysinh());
            ps.setDouble(4, sv.getDiem());
            ps.setString(5, sv.getLop().getMalop());
            return ps.executeUpdate() > 0;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }


    public boolean delete(String mssv){
        String sql = "DELETE FROM SINHVIEN WHERE mssv = ?";
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, mssv);
            return ps.executeUpdate() > 0;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }


    public SinhVien findByMssv(String mssv){
        String sql = "SELECT sv.mssv, sv.hoten, sv.ngaysinh,sv.diem, l.malop, l.tenlop  from SINHVIEN sv JOIN LOP l ON sv.malop = l.malop where sv.mssv = ?";
        try(
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
                ){

            ps.setString(1, mssv);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new SinhVien(
                        rs.getString("mssv"),
                        rs.getString("hoten"),
                        rs.getString("ngaysinh"),
                        rs.getDouble("diem"),
                        new Lop(rs.getString("malop"), rs.getString("tenlop"))

                        );
            }
        }catch (SQLException e){
            e.printStackTrace();

        }
        return null;
    }


    public boolean update(SinhVien sv){
        String sql = "UPDATE SINHVIEN SET hoten = ?, ngaysinh = ?, diem = ?, malop = ? WHERE mssv = ?";
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, sv.getHoten());
            ps.setString(2, sv.getNgaysinh());
            ps.setDouble(3, sv.getDiem());
            ps.setString(4, sv.getLop().getMalop());
            ps.setString(5, sv.getMssv());
            return ps.executeUpdate() > 0;

        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}