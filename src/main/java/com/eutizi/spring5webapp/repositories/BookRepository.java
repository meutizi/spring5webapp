package com.eutizi.spring5webapp.repositories;

import com.eutizi.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
    
}