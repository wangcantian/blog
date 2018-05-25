package com.paul.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xiaotiantian
 * @create 2018-05-25 16:54
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/login")
    public String login(Model model) {
        return "";
    }
}
