package com.fit.controller;

import com.fit.entity.Book;
import com.fit.entity.Category;
import com.fit.service.BookService;
import com.fit.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;


    @Autowired
    private CategoryService categoryService;

   //TRANG CHỦ
//    @GetMapping("/home")
//    public ModelAndView showHomePage() {
//        ModelAndView mav = new ModelAndView("Home");
//        mav.addObject("books", bookService.getBooks());
//        mav.addObject("dsCategory", categoryService.getAllCategories()); //chỉ có menu lọc category
//        return mav;
//    }

    @GetMapping("/home")
    public ModelAndView showHomePage() {
        ModelAndView mav = new ModelAndView("Home1");

        List<Category> dsCategory = categoryService.getAllCategories();

        mav.addObject("dsCategory", dsCategory);

        Map<Integer, List<Book>> dsBook = new HashMap<>();

        for(Category c : dsCategory) {
            List<Book> ds = bookService.findBookByCategoryID(c.getId());
            dsBook.put(c.getId(), ds);
        }
        mav.addObject("map", dsBook);
        return mav;
    }


//    @GetMapping("/home")
//    public ModelAndView showHomePage(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
//                                     @RequestParam(value = "sortField", defaultValue = "id") String sortField,
//                                     @RequestParam(value = "sortDirection", defaultValue = "asc") String sortDirection) {
//        ModelAndView mav = new ModelAndView("Home");
//
//        //so san pham tren 1 trang
//        int pageSize = 1;
//        //goi Ham
//        Page<Book> page = bookService.findPaginated(pageNo, pageSize, sortField, sortDirection);
//
//        mav.addObject("books", page.getContent());
//
//        mav.addObject("dsCategory", categoryService.getAllCategories());
//
//        mav.addObject("currentPage", pageNo);
//        mav.addObject("totalPages", page.getTotalPages());
//        mav.addObject("totalItems", page.getTotalElements());
//        mav.addObject("sortField", sortField);
//        mav.addObject("sortDirection", sortDirection);
//
//        return mav;
//    }


    // SHOW BOOK BY CATEGORY
    @GetMapping("/viewCategory")
    public ModelAndView showBookByCategory(@RequestParam("category") int id) {
        ModelAndView mav = new ModelAndView("Home");
        mav.addObject("books", bookService.findBookByCategoryID(id));
        mav.addObject("dsCategory", categoryService.getAllCategories());
        return mav;
    }


    //THÊM

    @GetMapping("/formAdd")
    public ModelAndView showFormAdd() {
        ModelAndView mav = new ModelAndView("Add");
        mav.addObject("book", new Book());
        mav.addObject("dsCategory", categoryService.getAllCategories());
        return mav;
    }

    @PostMapping("/addBook")
    public ModelAndView addBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            ModelAndView mav = new ModelAndView("Add");
            mav.addObject("dsCategory", categoryService.getAllCategories());
            return mav;
        }else{
            bookService.addBook(book);
            return new ModelAndView("redirect:/book/home");
        }
    }

    //CẬP NHẬT
    @GetMapping("/formUpdate")
    public ModelAndView showFormAdd(@ModelAttribute("id") int id) {
        ModelAndView mav = new ModelAndView("Update");
        mav.addObject("book", bookService.getBookById(id));
        mav.addObject("dsCategory", categoryService.getAllCategories());
        return mav;
    }

    @PostMapping("/updateBook")
    public ModelAndView updateBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            ModelAndView mav = new ModelAndView("Update");
            mav.addObject("dsCategory", categoryService.getAllCategories());
            return mav;
        }else{
            bookService.updateBook(book);
            return new ModelAndView("redirect:/book/home");
        }
    }



    //XEM CHI TIẾT
    @GetMapping("/detail")
    public ModelAndView viewDetail(@ModelAttribute("id") int id) {
        ModelAndView mav = new ModelAndView("Detail");
        Book b = bookService.getBookById(id);
        mav.addObject("book", b);
        return mav;
    }


    //XÓA
    @GetMapping("/delete")
    public ModelAndView deleteBook(@ModelAttribute("id") int id) {
        bookService.deleteBook(id);
        return new ModelAndView("redirect:/book/home");
    }


    //TÌM KIẾM
    @PostMapping("search")
    public ModelAndView search (@RequestParam("keyword") String keyword) {
        ModelAndView modelAndView = new ModelAndView("Home");

        List<Book> dsBook;

        try {
            // Kiểm tra nếu input là ngày
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);
            Date date = sdf.parse(keyword);
            // Nếu đúng là ngày, tìm theo ngày
            dsBook =  bookService.searchByDate(date);
        } catch (Exception e) {
            dsBook =  bookService.search(keyword);
        }

        modelAndView.addObject("books", dsBook);
        modelAndView.addObject("dsCategory", categoryService.getAllCategories());


        return modelAndView;

    }

}
