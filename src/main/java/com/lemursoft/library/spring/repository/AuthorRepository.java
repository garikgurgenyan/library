package com.lemursoft.library.spring.repository;

import com.lemursoft.library.domain.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByFioContainingIgnoreCaseOrderByFio(String fio);
    Page<Author> findByFioContainingIgnoreCaseOrderByFio(String fio, Pageable pageable);
}
