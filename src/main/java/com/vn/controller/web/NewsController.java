package com.vn.controller.web;

import com.vn.entity.Category;
import com.vn.entity.News;
import com.vn.service.Interface.ICategoryService;
import com.vn.service.Interface.INewsService;
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
@RequestMapping("/news")
public class NewsController {
    @Autowired
    INewsService iNewsService;

    @Autowired
    ICategoryService iCategoryService;

    //list news
//    @GetMapping("/list")
//    public String showList(Model model){
//        List<News> newsList = iNewsService.findAll();
//        model.addAttribute("newsList", newsList);
//        return "web/news/list";
//    }

    @GetMapping("/list")
    public String showList(Model model,  @RequestParam(value = "page") Optional<Integer> page){
        int currentPage = page.orElse(1);
        int pageSize =  5;

        Page<News> news = iNewsService.findAll( PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("news",news);

        int numbers = news.getNumber();
        int totalItems = news.getNumberOfElements();
        int totalPages = news.getTotalPages();

        List<Category> categoryList = iCategoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("numbers", numbers);
        return "web/news/list";
    }

    //create news
    @GetMapping("/create")
    public String viewCreate(Model model) {
        List<Category> categoryList = iCategoryService.findAll();
        News news = new News();
        news.setCategory(new Category());
        model.addAttribute("news", news);
        model.addAttribute("categoryList", categoryList);
        return "web/news/create";
    }
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("news") News news, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
//        CustomerValidation customerValidation = new CustomerValidation();
//        customerValidation.validate(customer, bindingResult);
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

    //delete news
    @GetMapping("/delete")
    public String delete(@RequestParam("idDelete") Integer id, RedirectAttributes redirectAttributes) {
        iNewsService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Delete success");
        return "redirect:/news/list";
    }

    //view news
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") int id, Model model) {
        News news = iNewsService.findById(id);
        model.addAttribute("news", news);
        return "web/news/view";
    }

    //edit news
    @GetMapping("/edit/{id}")
    public String viewUpdate(@PathVariable("id") int id, Model model) {
        List<Category> categoryList = iCategoryService.findAll();
        News news = iNewsService.findById(id);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("news", news);
        return "web/news/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("news") News news, Model model, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("mess", "Update success");
        iNewsService.update(news);
        return "redirect:/news/list";
    }
}
