package com.library.controller;

import com.library.model.Book;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepo;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Optional<Book> bookss = bookRepo.findById(id);
        if (bookss.isPresent()) {
            return ResponseEntity.ok(bookss.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Book createBook(@RequestBody Book rbook) {
        return bookRepo.save(rbook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        Optional<Book> optBook = bookRepo.findById(id);
        if (optBook.isPresent()) {
            Book book = optBook.get();
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            return ResponseEntity.ok(bookRepo.save(book));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        Optional<Book> books = bookRepo.findById(id);
        if (books.isPresent()) {
            bookRepo.delete(books.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
