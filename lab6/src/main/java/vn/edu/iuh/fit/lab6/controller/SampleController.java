package vn.edu.iuh.fit.lab6.controller;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.lab6.services.SampleServices;

@Controller
@RequestMapping("/sample")
public class SampleController {
    @Autowired
    private SampleServices servie;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(@PathParam("a") int a, @PathParam("b") int b){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("hi", "hi");
        mav.addObject("cong", ""+servie.cong(a, b));
        return mav;
    }

    @RequestMapping(value = "/cong", method = RequestMethod.GET)
    public ModelAndView cong(){
        ModelAndView mav = new ModelAndView("cong");
        mav.addObject("cong", ""+servie.cong(1, 2));
        return mav;
    }
}
