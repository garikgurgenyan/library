package com.lemursoft.library.spring.controller;

import com.lemursoft.library.dao.impl.AuthorService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Log
public class RedirectController {



    @RequestMapping(value = "", method = RequestMethod.GET)
    public String baseUrlRedirect(HttpServletRequest request, HttpServletResponse response) {
        // перенаправление на страницу индекс
        return "redirect:" + request.getRequestURL().append("/index.xhtml").toString();
    }
}

