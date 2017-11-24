package com.lemursoft.library.jsfui.controller;

import com.lemursoft.library.dao.GenreDao;
import com.lemursoft.library.domain.Genre;
import com.lemursoft.library.jsfui.model.LazyDataTable;
import lombok.Getter;
import lombok.Setter;
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
public class GenreController extends AbstractController {

    private int rowsCount = 20;
    private int first;

    @Autowired
    private GenreDao genreDao;

    private Genre selectedGenre;

    private LazyDataTable<Genre> lazyModel;

    private Page<Genre> genrePages;

    @PostConstruct
    public void init() {
        lazyModel = new LazyDataTable<>(this);
    }

    @Override
    public Page search(int first, int count, String sortField, Sort.Direction sortDirection) {
        return genrePages;
    }

    public List<Genre> getAll() {
        return genreDao.getAll(new Sort(Sort.Direction.ASC, "name"));
    }
}
