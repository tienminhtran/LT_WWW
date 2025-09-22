package com.fit.controller;

import com.fit.entity.Category;
import com.fit.entity.Product;
import com.fit.service.CategoryService;
import com.fit.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    // Trang chủ
    @GetMapping("home")
    public ModelAndView home(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
                             @RequestParam(value = "sortField", defaultValue = "name") String sortField,
                             @RequestParam(value = "sortDirection", defaultValue = "asc") String sortDirection) {
        ModelAndView modelAndView = new ModelAndView("home");

        // Lấy danh sách sản phẩm phân trang
        int pageSize = 10; // số lượng sản phẩm mỗi trang
        Page<Product> page = productService.findPaginated(pageNo, pageSize, sortField, sortDirection);

        // Lấy danh sách danh mục (category)
        List<Category> dsCategory = categoryService.getAllCategories();

        // Thêm dữ liệu vào ModelAndView
        modelAndView.addObject("dsCategory", dsCategory);
        modelAndView.addObject("dsProduct", page.getContent()); // lấy danh sách sản phẩm từ trang hiện tại
        modelAndView.addObject("currentPage", pageNo);
        modelAndView.addObject("totalPages", page.getTotalPages());
        modelAndView.addObject("totalItems", page.getTotalElements());
        modelAndView.addObject("sortField", sortField);
        modelAndView.addObject("sortDirection", sortDirection);

        return modelAndView;
    }



    //Thêm product
    @GetMapping("showFormAddProduct")
    public ModelAndView showFormAddProduct () {
        ModelAndView modelAndView = new ModelAndView("formAddProduct");

        List<Category> dsCategory = categoryService.getAllCategories();


        modelAndView.addObject("dsCategory", dsCategory);
        modelAndView.addObject("product", new Product());

        return modelAndView;
    }

    @PostMapping("addProduct")
    public ModelAndView addProduct (@Valid @ModelAttribute("product") Product product , BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("formAddProduct");

            List<Category> dsCategory = categoryService.getAllCategories();

            modelAndView.addObject("dsCategory", dsCategory);
            modelAndView.addObject("product", product);

            return modelAndView;
        }
        productService.saveProduct(product);
        return new ModelAndView("redirect:/product/home");
    }

    //Thêm category
    @GetMapping("showFormAddCategory")
    public ModelAndView showFormAddCategory () {
        ModelAndView modelAndView = new ModelAndView("formAddCategory");

        List<Category> dsCategory = categoryService.getAllCategories();
        modelAndView.addObject("dsCategory", dsCategory);
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("addCategory")
    public ModelAndView addCategory (@Valid @ModelAttribute("category") Category category , BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("formAddCategory");

            List<Category> dsCategory = categoryService.getAllCategories();
            modelAndView.addObject("dsCategory", dsCategory);
            modelAndView.addObject("category", category);
            return modelAndView;
        }
        categoryService.saveCategory(category);
        return new ModelAndView("redirect:/product/home");
    }


    //Sửa product
    @GetMapping("showFormEditProduct")
    public ModelAndView showFormEditProduct (@ModelAttribute("id") int id) {
        ModelAndView modelAndView = new ModelAndView("formUpdateProduct");

        modelAndView.addObject("product", productService.getProductById(id));
        modelAndView.addObject("dsCategory", categoryService.getAllCategories());

        return modelAndView;
    }

    @PostMapping("updateProduct")
    public ModelAndView updateProduct (@Valid @ModelAttribute("product") Product product , BindingResult result) {
        if (result.hasErrors()) {  // Nếu có lỗi
            ModelAndView modelAndView = new ModelAndView("formUpdateProduct");
            modelAndView.addObject("product", product);
            modelAndView.addObject("dsCategory", categoryService.getAllCategories());
            return modelAndView;
        }else {
            productService.updateProduct(product);
            return new ModelAndView("redirect:/product/home");
        }
    }


    // Xóa product
    @GetMapping("delete")
    public ModelAndView deleteProduct (@ModelAttribute("id") int id) {
        productService.deleteProduct(id);
        return new ModelAndView("redirect:/product/home");
    }

    //Xem chi tiết
    @GetMapping("showDetail")
    public ModelAndView showDetail (@ModelAttribute("id") int id) {
        ModelAndView modelAndView = new ModelAndView("viewDetail");

        Product product = productService.getProductById(id);

        modelAndView.addObject("product", product);

        return modelAndView;
    }


    //Product by category
    @GetMapping("viewCategory")
    public ModelAndView productByCategory (@RequestParam("category") int id) {
        ModelAndView modelAndView = new ModelAndView("category");

        List<Product> dsProduct = productService.findByCategoryId(id);
        List<Category> dsCategory = categoryService.getAllCategories();

        modelAndView.addObject("dsCategory", dsCategory);
        modelAndView.addObject("dsProduct", dsProduct);

        return modelAndView;
    }





    //Search
    @PostMapping("search")
    public ModelAndView search (@RequestParam("keyword") String keyword) {
        ModelAndView modelAndView = new ModelAndView("home");

        List<Product> dsProduct;

        try {
            // Kiểm tra nếu input là ngày
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);
            Date date = sdf.parse(keyword);
            // Nếu đúng là ngày, tìm theo ngày
            dsProduct =  productService.searchByDate(date);
        } catch (Exception e) {
            dsProduct =  productService.searchByKeyWord(keyword);
        }

        List<Category> dsCategory = categoryService.getAllCategories();


        modelAndView.addObject("dsCategory", dsCategory);
        modelAndView.addObject("dsProduct", dsProduct);


        return modelAndView;

    }


}
