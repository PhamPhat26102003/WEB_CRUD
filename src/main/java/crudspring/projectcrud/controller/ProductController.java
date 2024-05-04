package crudspring.projectcrud.controller;

import crudspring.projectcrud.entity.Product;
import crudspring.projectcrud.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping("/")
    public String ViewHomePage(Model model, @Param("keyword") String keyword){
        List<Product> productList = productService.getAll(keyword);
        model.addAttribute("productList", productList);
        model.addAttribute("keyword", keyword);
        return "index";
    }

    @RequestMapping("/new")
    public String ViewAddProduct(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
    }

    @PostMapping("/create")
    public String CreateNewProduct(@ModelAttribute("product") Product product){
        productService.save(product);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView ViewEditProduct(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("edit_product");
        Product product = productService.get(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String DeleteProduct(@PathVariable(name = "id") Long id){
        productService.delete(id);
        return "redirect:/";
    }
}
