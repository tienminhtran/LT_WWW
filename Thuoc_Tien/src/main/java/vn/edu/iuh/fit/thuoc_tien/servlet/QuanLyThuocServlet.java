package vn.edu.iuh.fit.thuoc_tien.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.edu.iuh.fit.thuoc_tien.dao.QuanLyLoaiThuocDAO;
import vn.edu.iuh.fit.thuoc_tien.dao.QuanLyThuocDAO;
import vn.edu.iuh.fit.thuoc_tien.model.Thuoc;

import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/thuoc")
public class QuanLyThuocServlet extends HttpServlet {
        private final QuanLyThuocDAO dao = new QuanLyThuocDAO();
        private final QuanLyLoaiThuocDAO daoLoai = new QuanLyLoaiThuocDAO();

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {
            String action = req.getParameter("action");
            if (action == null) action = "danhsachthuoc";

            try {
                switch (action) {
                    case "add": // chuyển sang form thêm thuốc
                        req.getRequestDispatcher("/themthuoc.jsp").forward(req, resp);
                        break;

                    case "danhsachloaithuoc": // hiển thị danh sách loại thuốc
                        req.setAttribute("dsLoaiThuoc", daoLoai.findAll());
                        req.getRequestDispatcher("/danhsachloaithuoc.jsp").forward(req, resp);
                        break;

//                    case "danhsachthuoc": // hiển thị danh sách thuốc
//                    default:
//                        req.setAttribute("dsThuoc", dao.findAll());
//                        req.getRequestDispatcher("/danhsachthuoc.jsp").forward(req, resp);
//                        break;

//                    khi có loọc theo loại thuốc
                    case "danhsachthuoc": // hiển thị danh sách thuốc
                    default:
                        // lấy tất cả loại thuốc để đưa vào listbox
                        req.setAttribute("dsLoaiThuoc", daoLoai.findAll());

                        // kiểm tra xem có chọn loại thuốc nào chưa
                        String maLoaiStr = req.getParameter("maLoai");
                        if (maLoaiStr != null && !maLoaiStr.isEmpty()) {
                            int maLoai = Integer.parseInt(maLoaiStr);
                            req.setAttribute("dsThuoc", dao.findByLoai(maLoai)); // lọc theo loại
                            req.setAttribute("maLoai", maLoai); // để giữ trạng thái listbox
                        } else {
                            req.setAttribute("dsThuoc", dao.findAll()); // hiển thị tất cả
                        }

                        req.getRequestDispatcher("/danhsachthuoc.jsp").forward(req, resp);
                        break;




                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new ServletException(e);
            }
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {
            String action = req.getParameter("action");
            if (action == null) action = "danhsachthuoc";

            try {
                if ("insert".equals(action)) {
                    String tenThuoc = req.getParameter("tenThuoc");
                    BigDecimal gia = new BigDecimal(req.getParameter("gia"));
                    int namNX = Integer.parseInt(req.getParameter("namNX"));
                    int maLoai = Integer.parseInt(req.getParameter("maLoai"));

                    Thuoc t = new Thuoc(0, tenThuoc, gia, namNX, maLoai);
                    dao.insert(t);

                    HttpSession session = req.getSession();
                    session.setAttribute("msg", "---------------------- Thêm thuốc thành công!");
                    resp.sendRedirect(req.getContextPath() + "/thuoc?action=danhsachthuoc");

                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new ServletException(e);
            }
        }

    }




