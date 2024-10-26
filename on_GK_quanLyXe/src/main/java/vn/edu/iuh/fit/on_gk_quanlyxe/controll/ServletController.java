package vn.edu.iuh.fit.on_gk_quanlyxe.controll;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import vn.edu.iuh.fit.on_gk_quanlyxe.services.XeService;
import vn.edu.iuh.fit.on_gk_quanlyxe.services.impl.XeServiceImpl;

@WebServlet (name="ServletController", urlPatterns = "/controller")
public class ServletController extends HttpServlet{

    private final XeService xeService;

    public ServletController() {
        this.xeService = new XeServiceImpl();
    }




}
