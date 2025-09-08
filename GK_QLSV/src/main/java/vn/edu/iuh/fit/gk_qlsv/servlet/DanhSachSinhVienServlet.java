package vn.edu.iuh.fit.gk_qlsv.servlet;

import vn.edu.iuh.fit.gk_qlsv.dao.SinhVienDAO;
import vn.edu.iuh.fit.gk_qlsv.model.SinhVien;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/danh-sach-sinh-vien")
public class DanhSachSinhVienServlet extends HttpServlet {
    private SinhVienDAO dao = new SinhVienDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        try {
            if ("delete".equals(action)) {
                // Xóa sinh viên theo mssv
                String mssv = req.getParameter("mssv");
                if (mssv != null && !mssv.isEmpty()) {
                    dao.deleteByMssv(mssv);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Xóa sinh viên thất bại: " + e.getMessage());
        }

        // Lấy danh sách sinh viên (có thể lọc điểm nếu có)
        String minStr = req.getParameter("minDiem");
        String maxStr = req.getParameter("maxDiem");
        List<SinhVien> ds;

        try {
            if (minStr != null && maxStr != null && !minStr.isEmpty() && !maxStr.isEmpty()) {
                double minDiem = Double.parseDouble(minStr);
                double maxDiem = Double.parseDouble(maxStr);
                ds = dao.findByDiem(minDiem, maxDiem);
            } else {
                ds = dao.findAll();
            }
        } catch (NumberFormatException e) {
            req.setAttribute("error", "Điểm nhập không hợp lệ!");
            ds = dao.findAll();
        }

        req.setAttribute("sinhviens", ds);
        req.getRequestDispatcher("sinhvien-list.jsp")
                .forward(req, resp);
    }
}
