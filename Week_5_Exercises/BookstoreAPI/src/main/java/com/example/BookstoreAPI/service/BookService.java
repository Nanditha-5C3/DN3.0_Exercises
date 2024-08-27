package com.example.BookstoreAPI.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookstoreAPI.exception.ResourceNotFoundException;
import com.example.BookstoreAPI.model.Book;
import com.example.BookstoreAPI.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private static BookRepository bookRepo;

    public Book createBook(Book book) {
        return bookRepo.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepo.findById(id);
    }

    public Book updateBook(Long id, Book bookDetails) {
        Book book = bookRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + id));
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setPrice(bookDetails.getPrice());
        return bookRepo.save(book);
    }

    public static void deleteBook(Long id) {
        Book book = bookRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + id));
        bookRepo.delete(book);
    }

	public Book addBook(Book book) {
		return null;
	}
}