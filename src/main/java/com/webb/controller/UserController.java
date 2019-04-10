package com.webb.controller;

import com.webb.dao.UserT;
import com.webb.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping(value = "/showUser")
    public String toIndex(HttpServletRequest request, Model model) {
        int userId = Integer.valueOf(request.getParameter("id"));
        UserT userT = userService.getUserById(userId);
        model.addAttribute("user", userT);
        return "showUser";
    }

}
