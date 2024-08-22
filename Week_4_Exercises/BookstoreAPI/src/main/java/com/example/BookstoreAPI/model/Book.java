package com.example.BookstoreAPI.model;

import java.util.List;

import com.example.BookstoreAPI.dto.BookDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    private String title;
    private String author;
    private double price;
    private String isbn;
	
	@Version
    private Long version;

	public void setTitle(Object title2) {
		
	}

	public void setAuthor(Object author2) {
		
	}

	public void setPrice(Object price2) {
		
	}

	public void setIsbn(Object isbn2) {
		
	}

	public List<BookDTO> getTitle() {
		
		return null;
	}

	public List<BookDTO> getAuthor() {
		
		return null;
	}

}
