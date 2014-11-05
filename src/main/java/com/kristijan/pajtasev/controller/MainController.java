package com.kristijan.pajtasev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by kristijan on 05.11.14..
 */
@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String index() {
        return "Hello world";
    }

    @RequestMapping(value = "/test")
    public String indexTemplate(Model model) {
        return "index";
    }

}
