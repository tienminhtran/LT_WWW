package com.fit.controller;

import com.fit.entity.Order;
import com.fit.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    //HIEN THI TAT CA
    @GetMapping("/home")
    public ModelAndView showAll(){
       ModelAndView mav = new ModelAndView("Home");
       mav.addObject("dsOrder", orderService.getAll());
       return mav;
    }

    //THEM
    @GetMapping("/formAdd")
    public ModelAndView showFormAdd(){
        ModelAndView mav = new ModelAndView("Add");
        mav.addObject("order",new Order());
        return mav;
    }

    @PostMapping("/add")
    public ModelAndView add(@Valid @ModelAttribute("order") Order o, BindingResult result){
        if(result.hasErrors()){
            ModelAndView mav = new ModelAndView("Add");
            return mav;
        }else{
            orderService.addOrder(o);
            return new ModelAndView("redirect:/order/home");
        }
    }

    //XEM CHI TIET
    @GetMapping("/detail")
    public ModelAndView viewDetail(@ModelAttribute("id") int id){
        ModelAndView mav = new ModelAndView("Detail");
        mav.addObject("o", orderService.getById(id));
        return mav;
    }


    //CAPNHAT
    @GetMapping("/formUpdate")
    public ModelAndView showFormUpdate(@ModelAttribute("id") int id){
        ModelAndView mav = new ModelAndView("Update");
        mav.addObject("order",orderService.getById(id));
        return mav;
    }

    @PostMapping("/update")
    public ModelAndView update(@Valid @ModelAttribute("order") Order o, BindingResult result){
        if(result.hasErrors()){
            ModelAndView mav = new ModelAndView("Update");
            return mav;
        }else{
            orderService.updateOrder(o);
            return new ModelAndView("redirect:/order/home");
        }
    }

    //TÌM THEO ID
    @GetMapping("/search")
    public ModelAndView search(@RequestParam("keyword") int keyword){
        ModelAndView mav = new ModelAndView("Detail");
        mav.addObject("o", orderService.getById(keyword));
        return mav;
    }
}
