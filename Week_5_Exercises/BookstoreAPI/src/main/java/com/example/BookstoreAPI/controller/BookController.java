package com.example.BookstoreAPI.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.BookstoreAPI.dto.BookDTO;
import com.example.BookstoreAPI.exception.ResourceNotFoundException;
import com.example.BookstoreAPI.mapper.BookMapper;
import com.example.BookstoreAPI.model.Book;
import com.example.BookstoreAPI.repository.BookRepository;
import com.example.BookstoreAPI.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private BookMapper bookMap;

    @Autowired
    private BookService bookSrvc;

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

        // Ensure the correct types are passed
        existingBook.setTitle(bookDTO.getTitle().toString());
        existingBook.setAuthor(bookDTO.getAuthor().toString());
        existingBook.setPrice(Double.valueOf(bookDTO.getPrice().toString()));
        existingBook.setIsbn(bookDTO.getIsbn().toString());

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
            // Handle XML-specific logic here if needed
        }

        return bookDTO;
    }

    @GetMapping("/entity/{id}")
    public EntityModel<Book> getBookEntity(@PathVariable Long id) {
        Book book = bookSrvc.getBookById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));

        EntityModel<Book> resource = EntityModel.of(book);
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBookById(id)).withSelfRel());
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getAllBooks()).withRel("all-books"));

        return resource;
    }

    @PostMapping("/create")
    public ResponseEntity<Book> createBookEntity(@RequestBody @Validated Book book) {
        Book saved = bookSrvc.createBook(book);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBookEntity(@PathVariable Long id, @RequestBody @Validated Book book) {
        Book updated = bookSrvc.updateBook(id, book);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBookEntity(@PathVariable Long id) {
        BookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
