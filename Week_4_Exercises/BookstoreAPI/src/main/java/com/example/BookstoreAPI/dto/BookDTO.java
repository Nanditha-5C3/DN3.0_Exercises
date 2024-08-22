package com.example.BookstoreAPI.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Long id;

    @Nonnull

    private String title;

    @Nonnull

    private String author;

    @Nonnull

    private Double price;

    @Nonnull

    private String isbn;

	public Object getTitle() {
		return null;
	}

	public Object getAuthor() {
		return null;
	}

	public Object getPrice() {
		return null;
	}

	public Object getIsbn() {
		return null;
	}

}

