package com.vn.controller.admin;

import com.vn.entity.Category;
import com.vn.entity.News;
import com.vn.service.Interface.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ICategoryService iCategoryService;

    //list category
    @GetMapping("/list")
    public String showList(Model model,  @RequestParam(value = "page") Optional<Integer> page){
        int currentPage = page.orElse(1);
        int pageSize =  5;

        Page<Category> categories = iCategoryService.findAll( PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("categories",categories);

        int numbers = categories.getNumber();
        int totalItems = categories.getNumberOfElements();
        int totalPages = categories.getTotalPages();

        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("numbers", numbers);
        return "admin/category/list";
    }

    //create category
    @GetMapping("/create")
    public String viewCreate(Model model) {
        Category categories = new Category();
        model.addAttribute("categories", categories);
        return "admin/category/create";
    }
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("news") News news, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            news.setCategory(new Category());
            List<Category> categoryList = iCategoryService.findAll();
            model.addAttribute("news", news);
            model.addAttribute("categoryList", categoryList);
            return "web/news/create";
        }
        redirectAttributes.addFlashAttribute("mess", "Add new success");
        iNewsService.create(news);
        return "redirect:/news/list";
    }
}
