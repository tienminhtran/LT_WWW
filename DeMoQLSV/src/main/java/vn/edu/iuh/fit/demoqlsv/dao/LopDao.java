package vn.edu.iuh.fit.demoqlsv.dao;

import vn.edu.iuh.fit.demoqlsv.model.Lop;
import vn.edu.iuh.fit.demoqlsv.utlis.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LopDao {
    public List<Lop> findAll() {
        List<Lop> list = new ArrayList<>();
        String sql = "SELECT malop, tenlop FROM LOP";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Lop(rs.getString("malop"), rs.getString("tenlop")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
