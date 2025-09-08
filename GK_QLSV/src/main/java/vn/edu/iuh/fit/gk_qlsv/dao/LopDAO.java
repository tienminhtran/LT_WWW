/**
 * @ (#) LopDAO.java      9/8/2025
 * <p>
 * Copyright (c) 2025 IUH. All rights reserved
 */

package vn.edu.iuh.fit.gk_qlsv.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import vn.edu.iuh.fit.gk_qlsv.model.Lop;
import vn.edu.iuh.fit.gk_qlsv.utlis.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * @description: DAO cho entity Lop sử dụng JPA
 * @author: Tien Minh Tran
 * @date: 9/8/2025
 */
public class LopDAO {

    public List<Lop> findAll() {
        List<Lop> list = new ArrayList<>();
        String sql = "SELECT malop, tenlop FROM LOP";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Lop lop = new Lop(rs.getString("malop"), rs.getString("tenlop"));
                list.add(lop);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
