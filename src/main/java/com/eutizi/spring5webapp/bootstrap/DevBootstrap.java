package com.eutizi.spring5webapp.bootstrap;

import com.eutizi.spring5webapp.model.*;
import com.eutizi.spring5webapp.repositories.*;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
    
    private void initData() {
        Author eric = new Author("Eric", "Evans");
        Publisher harper = new Publisher("Harper Collins", "123 Anywhere");
        Book ddd = new Book("Domain Driven Design", "1234", harper);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        publisherRepository.save(harper);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Publisher worx = new Publisher("Worx", "333 Anywhere");
        Book noEJB = new Book("J2EE Development without EJB", "2344", worx);
        rod.getBooks().add(noEJB);
        
        authorRepository.save(rod);
        publisherRepository.save(worx);
        bookRepository.save(noEJB);
    }
}