package com.example.BookstoreAPI.dto;

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
		return title;
	}

	public Object getAuthor() {
		return author;
	}

	public Object getPrice() {
		return price;
	}

	public Object getIsbn() {
		return isbn;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
}
