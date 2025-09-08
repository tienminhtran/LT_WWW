package vn.edu.iuh.fit.gk_qlsv.servlet;

import vn.edu.iuh.fit.gk_qlsv.dao.SinhVienDAO;
import vn.edu.iuh.fit.gk_qlsv.model.SinhVien;
import vn.edu.iuh.fit.gk_qlsv.model.Lop;
import vn.edu.iuh.fit.gk_qlsv.dao.LopDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/sua-sinhvien")
public class SuaSinhVienServlet extends HttpServlet {

    private SinhVienDAO svDAO = new SinhVienDAO();
    private LopDAO lopDAO = new LopDAO();

    // Hiển thị form sửa sinh viên
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String mssv = req.getParameter("mssv");
        if (mssv != null) {
            SinhVien sv = svDAO.findByMssv(mssv); // cần viết DAO findByMssv
            req.setAttribute("sv", sv);

            List<Lop> lops = lopDAO.findAll(); // danh sách lớp để chọn
            req.setAttribute("lops", lops);

            req.getRequestDispatcher("sua-sinhvien.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("danh-sach-sinh-vien");
        }
    }

    // Xử lý submit form sửa sinh viên
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String mssv = req.getParameter("mssv");
        String hoten = req.getParameter("hoten");
        String ngaysinhStr = req.getParameter("ngaysinh");
        String diemStr = req.getParameter("diem");
        String malop = req.getParameter("malop");

        try {
            Date ngaysinh = Date.valueOf(ngaysinhStr);
            double diem = Double.parseDouble(diemStr);

            SinhVien sv = new SinhVien();
            sv.setMssv(mssv);
            sv.setHoten(hoten);
            sv.setNgaysinh(ngaysinh);
            sv.setDiem(diem);
            sv.setLop(new Lop(malop, null));

            svDAO.update(sv); // cần viết DAO update

            resp.sendRedirect("danh-sach-sinh-vien");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Cập nhật thất bại: " + e.getMessage());
            req.getRequestDispatcher("sua-sinhvien.jsp").forward(req, resp);
        }
    }
}
