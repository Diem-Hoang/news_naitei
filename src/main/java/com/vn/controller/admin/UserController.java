package com.vn.controller.admin;

import com.vn.entity.User;
import com.vn.entity.News;
import com.vn.entity.Role;
import com.vn.service.Interface.IRoleService;
import com.vn.service.Interface.IUserService;

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
@RequestMapping("/user")
public class UserController {
	@Autowired
    IUserService iUserService;

    //list User
    @GetMapping("/list")
    public String showList(Model model,  @RequestParam(value = "page") Optional<Integer> page){
        int currentPage = page.orElse(1);
        int pageSize =  5;

        Page<User> users = iUserService.findAll( PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("users",users);

        int numbers = users.getNumber();
        int totalItems = users.getNumberOfElements();
        int totalPages = users.getTotalPages();

        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("numbers", numbers);
        return "admin/user/list";
    }

    //create User
    @GetMapping("/create")
    public String viewCreate(Model model) {
        User users = new User();
        model.addAttribute("users", users);
        return "admin/user/create";
    }
    
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("role") Role role, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            role.setUser(new User());
            List<User> userList = iUserService.findAll();
            model.addAttribute("role", role);
            model.addAttribute("UserList", userList);
            return "web/role/create";
        }
        redirectAttributes.addFlashAttribute("mess", "Add user success");
        IRoleService.save(role);
        return "redirect:/role/list";
    }
}
