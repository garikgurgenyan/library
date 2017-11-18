package com.lemursoft.library.dao.impl;

import com.lemursoft.library.dao.PublisherDao;
import com.lemursoft.library.domain.Publisher;
import com.lemursoft.library.spring.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PublisherService implements PublisherDao {

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public List<Publisher> getAll() {
        return publisherRepository.findAll();
    }

    @Override
    public List<Publisher> search(String... searchString) {
        return publisherRepository.findByNameContainingIgnoreCaseOrderByName(searchString[0]);
    }

    @Override
    public Publisher get(long id) {
        return publisherRepository.getOne(id);
    }

    @Override
    public Publisher save(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public void delete(Publisher publisher) {
        publisherRepository.delete(publisher);
    }

    @Override
    public List<Publisher> getAll(Sort sort) {
        return publisherRepository.findAll(sort);
    }

    @Override
    public Page<Publisher> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return publisherRepository.findAll(new PageRequest(pageNumber,pageSize,new Sort(sortDirection,sortField)));
    }

    @Override
    public Page<Publisher> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDireaction, String... searchString) {
        return publisherRepository.findByNameContainingIgnoreCaseOrderByName(searchString[0], new PageRequest(pageNumber, pageSize, new Sort(sortDireaction, sortField)));
    }
}
