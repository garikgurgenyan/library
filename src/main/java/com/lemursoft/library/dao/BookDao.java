package com.lemursoft.library.dao;

import com.lemursoft.library.domain.Book;

import java.util.List;

public interface BookDao extends GeneralDAO<Book> {
    List<Book> findTopBooks(int linit);
}
