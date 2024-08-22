package com.example.BookstoreAPI.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.BookstoreAPI.dto.BookDTO;
import com.example.BookstoreAPI.exception.ResourceNotFoundException;
import com.example.BookstoreAPI.mapper.BookMapper;
import com.example.BookstoreAPI.model.Book;
import com.example.BookstoreAPI.repository.BookRepository;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private BookMapper bookMap;

    @GetMapping
    public List<BookDTO> getAllBooks() {
        return bookRepo.findAll().stream()
                .map(bookMap::toBookDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
        Book book = bookRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));
        return ResponseEntity.ok(bookMap.toBookDTO(book));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO createBook(@Validated @RequestBody BookDTO bookDTO) {
        Book book = bookMap.toBook(bookDTO);
        Book savedBook = bookRepo.save(book);
        return bookMap.toBookDTO(savedBook);
    }

    @PutMapping("/{id}")
    public BookDTO updateBook(@PathVariable Long id, @Validated @RequestBody BookDTO bookDTO) {
        Book existingBook = bookRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));
        existingBook.setTitle(bookDTO.getTitle());
        existingBook.setAuthor(bookDTO.getAuthor());
        existingBook.setPrice(bookDTO.getPrice());
        existingBook.setIsbn(bookDTO.getIsbn());
        Book updatedBook = bookRepo.save(existingBook);
        return bookMap.toBookDTO(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        Book book = bookRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));
                bookRepo.delete(book);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<BookDTO> searchBooks(@RequestParam(required = false) String title,
                                      @RequestParam(required = false) String author) {
        // Implement the search logic here based on title and author
        // This method can be expanded based on your search criteria
        return bookRepo.findAll().stream()
                .filter(book -> (title == null || book.getTitle().contains(title)) &&
                                (author == null || book.getAuthor().contains(author)))
                .map(bookMap::toBookDTO)
                .collect(Collectors.toList());
    }
    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
    public BookDTO getBookById(@PathVariable Long id, @RequestHeader(value = "Accept", defaultValue = "application/json") String acceptHeader) {
        Book book = bookRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));
        
        BookDTO bookDTO = bookMap.toBookDTO(book);
        
        if (acceptHeader.equals("application/xml")) {
            // Convert to XML if required
        }

        return bookDTO;
    }

}
