package com.lemursoft.library.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(catalog = "library")
@Getter @Setter
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
@EqualsAndHashCode(of = "id")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Basic(fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "publisher")
    private List<Book> books;

    @Override
    public String toString() {
        return name;
    }
}
