package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepo;

    // Setter method for BookRepository
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
