package com.lemursoft.library.spring.controller;

import com.lemursoft.library.domain.Author;
import com.lemursoft.library.domain.Book;
import com.lemursoft.library.spring.repository.AuthorRepository;
import com.lemursoft.library.spring.repository.BookRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@Log
public class RedirectController {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String baseUrlRedirect(HttpServletRequest request, HttpServletResponse response) {

        Page<Book> bookList = bookRepository.findByGenre(15, new PageRequest(0, 10, new Sort(Sort.Direction.ASC, "name")));

        return "ok";
    }
}

