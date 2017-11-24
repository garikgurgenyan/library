package com.lemursoft.library.jsfui.controller;

import com.lemursoft.library.dao.BookDao;
import com.lemursoft.library.domain.Book;
import com.lemursoft.library.jsfui.enums.SearchType;
import com.lemursoft.library.jsfui.model.LazyDataTable;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import java.util.List;


@ManagedBean
@SessionScoped
@Component
@Getter @Setter
@Log
public class BookController extends AbstractController<Book>{

    public static final int DEFAULT_PAGE_SIZE = 20;

    private int rowsCount = DEFAULT_PAGE_SIZE;
    public static final int TOP_BOOKS_LIMIT = 5;

    private SearchType searchType;

    @Autowired
    private BookDao bookDao;

    private LazyDataTable<Book> lazyModel;

    private Page<Book> bookPages;
    private List<Book> topBooks;

    @PostConstruct
    public void init() {
        lazyModel = new LazyDataTable<>(this);
    }




    @Override
    public Page<Book> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {

        if (sortField == null) {
            sortField = "name";
        }

        if (searchType == null) {
            bookPages = bookDao.getAll(pageNumber, pageSize, sortField, sortDirection);
        } else {
            switch (searchType) {
                case SEARCH_GENRE:
                    break;
                case SEARCH_TEXT:
                    break;
                case ALL:
                    bookPages = bookDao.getAll(pageNumber, pageSize, sortField, sortDirection);
            }
        }

        return bookPages;
    }

    public List<Book> getTopBooks() {
        topBooks = bookDao.findTopBooks(TOP_BOOKS_LIMIT);
        return topBooks;
    }
}
