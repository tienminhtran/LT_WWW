package vn.edu.iuh.fit.gk_qlsv.servlet;

import vn.edu.iuh.fit.gk_qlsv.dao.SinhVienDAO;
import vn.edu.iuh.fit.gk_qlsv.model.SinhVien;
import vn.edu.iuh.fit.gk_qlsv.model.Lop;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

@WebServlet("/them-sinhvien")
public class ThemSinhVienServlet extends HttpServlet {

    private SinhVienDAO sinhVienDAO = new SinhVienDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String mssv = req.getParameter("mssv");
        String hoten = req.getParameter("hoten");
        String ngaysinhStr = req.getParameter("ngaysinh");
        String diemStr = req.getParameter("diem");
        String malop = req.getParameter("malop");

        try {
            Date ngaysinh = java.sql.Date.valueOf(ngaysinhStr);
            double diem = Double.parseDouble(diemStr);

            Lop lop = new Lop(malop, ""); // tên lớp có thể để rỗng nếu chưa cần
            SinhVien sv = new SinhVien(mssv, hoten, ngaysinh, diem, lop);

            // Gọi DAO để thêm sinh viên
            sinhVienDAO.insert(sv);

            // Chuyển về danh sách sinh viên
            resp.sendRedirect("danh-sach-sinh-vien");

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Thêm sinh viên thất bại: " + e.getMessage());
            req.getRequestDispatcher("them-sinhvien.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("them-sinhvien.jsp").forward(req, resp);
    }
}
