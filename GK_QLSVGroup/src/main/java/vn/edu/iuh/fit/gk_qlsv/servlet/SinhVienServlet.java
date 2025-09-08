package vn.edu.iuh.fit.gk_qlsv.servlet;

import vn.edu.iuh.fit.gk_qlsv.dao.SinhVienDAO;
import vn.edu.iuh.fit.gk_qlsv.model.Lop;
import vn.edu.iuh.fit.gk_qlsv.model.SinhVien;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/sinhvien")
public class SinhVienServlet extends HttpServlet {
    private SinhVienDAO dao = new SinhVienDAO();

    /** Hiển thị danh sách hoặc trang sửa sinh viên */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        if ("edit".equals(action)) {
            // Trang sửa sinh viên
            String mssv = req.getParameter("mssv");
            SinhVien sv = dao.findAll().stream()
                    .filter(s -> s.getMssv().equals(mssv))
                    .findFirst().orElse(null);

            if (sv != null) {
                req.setAttribute("sv", sv);
                req.getRequestDispatcher("sinhvien-edit.jsp").forward(req, resp);
            } else {
                resp.sendRedirect(req.getContextPath() + "/sinhvien");
            }

        } else {
            // Hiển thị danh sách sinh viên
            List<SinhVien> ds = dao.findAll();
            req.setAttribute("sinhviens", ds);
            req.getRequestDispatcher("sinhvien-list.jsp").forward(req, resp);
        }
    }

    /** Thực hiện thêm, sửa, xóa dựa theo _method */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String method = req.getParameter("_method");

        switch (method != null ? method.toLowerCase() : "add") {

            case "delete":
                String mssvDel = req.getParameter("mssv");
                if (dao.delete(mssvDel)) {
                    resp.sendRedirect(req.getContextPath() + "/sinhvien");
                } else {
                    req.setAttribute("error", "Xóa sinh viên thất bại!");
                    doGet(req, resp);
                }
                break;

            case "update":
                try {
                    String mssv = req.getParameter("mssv");
                    String hoten = req.getParameter("hoten");
                    String ngaysinh = req.getParameter("ngaysinh");
                    double diem = Double.parseDouble(req.getParameter("diem"));
                    String malop = req.getParameter("malop");

                    SinhVien sv = new SinhVien(mssv, hoten, java.sql.Date.valueOf(ngaysinh), diem, new Lop(malop, null));
                    if (dao.update(sv)) {
                        resp.sendRedirect(req.getContextPath() + "/sinhvien");
                    } else {
                        req.setAttribute("error", "Cập nhật thất bại!");
                        doGet(req, resp);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    req.setAttribute("error", "Dữ liệu không hợp lệ!");
                    doGet(req, resp);
                }
                break;

            case "add":
            default:
                try {
                    String mssv = req.getParameter("mssv");
                    String hoten = req.getParameter("hoten");
                    String ngaysinh = req.getParameter("ngaysinh");
                    double diem = Double.parseDouble(req.getParameter("diem"));
                    String malop = req.getParameter("malop");

                    SinhVien sv = new SinhVien(mssv, hoten, java.sql.Date.valueOf(ngaysinh), diem, new Lop(malop, null));
                    if (dao.insert(sv)) {
                        resp.sendRedirect(req.getContextPath() + "/sinhvien");
                    } else {
                        req.setAttribute("error", "Thêm sinh viên thất bại!");
                        doGet(req, resp);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    req.setAttribute("error", "Dữ liệu không hợp lệ!");
                    doGet(req, resp);
                }
                break;
        }
    }
}
