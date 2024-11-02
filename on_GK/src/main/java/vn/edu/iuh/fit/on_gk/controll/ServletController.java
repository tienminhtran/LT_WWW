package vn.edu.iuh.fit.on_gk.controll;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.on_gk.entity.HangXe;
import vn.edu.iuh.fit.on_gk.entity.Xe;
import vn.edu.iuh.fit.on_gk.services.HangXeService;
import vn.edu.iuh.fit.on_gk.services.XeService;
import vn.edu.iuh.fit.on_gk.services.impl.HangXeServiceImpl;
import vn.edu.iuh.fit.on_gk.services.impl.XeServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet (name="ServletController", value = "/controller")
public class ServletController extends HttpServlet{

    private  XeService xeService;
    private HangXeService hangXeService;

    public void init() {
        xeService = new XeServiceImpl();
        hangXeService = new HangXeServiceImpl();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        HttpSession session = req.getSession(true);
        if(action.equals("getDsXe")){
            List<Xe> xeList = xeService.getDsXe();
            session.setAttribute("dsXe", xeList); // lấy bên clinet qua jsp
            req.getRequestDispatcher("index.jsp").forward(req, resp); // tra ve trang index.jsp
        } else if(action.equals("themxe")){
            List< HangXe> hangXeList = hangXeService.getDsHangXe();
            session.setAttribute("hangXeList", hangXeList);


            session.setAttribute("xe", new Xe());

            req.getRequestDispatcher("form.jsp").forward(req, resp);
        } else if (action.equals("suaxe")){
            int maxe = Integer.parseInt(req.getParameter("maXe"));
            Xe xe = xeService.findByID(maxe);
            session.setAttribute("xe", xe);
            List<HangXe> hangXeList = hangXeService.getDsHangXe();
            session.setAttribute("hangXeList", hangXeList);
            req.getRequestDispatcher("form.jsp").forward(req, resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        HttpSession session = req.getSession(true);


        if(action.equals("timkiem")){
            String ten = req.getParameter("search");
            List<Xe> xeList = xeService.findByTenXe(ten);
            session.setAttribute("dsXe", xeList); // qua jsp
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
        else if(action.equals("themxe")){
            String tenXe = req.getParameter("tenXe");
            String giaXe = req.getParameter("gia");
            String namSX = req.getParameter("namSX");
            String mahangXe = req.getParameter("hangXe");

            HangXe hangXe1 = hangXeService.findByID(Integer.parseInt(mahangXe));

            Xe xe = new Xe(tenXe, Double.parseDouble(giaXe), namSX, hangXe1);
          boolean kq= xeService.addXe(xe);
          if(kq){
              resp.sendRedirect("controller?action=getDsXe");
          }
        }else if(action.equals("suaxe")) {
            String tenXe = req.getParameter("tenXe");
            String giaXe = req.getParameter("gia");
            String namSX = req.getParameter("namSX");
            String mahangXe = req.getParameter("hangXe");

            HangXe hangXe1 = hangXeService.findByID(Integer.parseInt(mahangXe));
            Xe xe = new Xe(Integer.parseInt(req.getParameter("maXe")), tenXe, Double.parseDouble(giaXe), namSX, hangXe1);
            boolean kq= xeService.updateXe(xe);
            if(kq){
                resp.sendRedirect("controller?action=getDsXe");
            }
        }
    }
}
