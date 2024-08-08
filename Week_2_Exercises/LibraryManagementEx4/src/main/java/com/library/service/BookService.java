package com.library.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.repository.BookRepository;

@Service
public class BookService {
    private BookRepository bookRepo;
    // Constructor for constructor injection
    public BookService(BookRepository bookRepository) {
        this.bookRepo = bookRepository;
    }

    // Setter method for BookRepository
    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepo = bookRepository;
    }
    public BookRepository getBookRepository() {
        return bookRepo;
    }
    public void someMethod() {
        System.out.println("Executing someMethod in BookService");
    }

}
