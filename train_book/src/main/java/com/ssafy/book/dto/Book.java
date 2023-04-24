package com.ssafy.book.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Builder
@NoArgsConstructor
public class Book {
	private String isbn;
	private String title;
	private String author;
	private int price;
	private String description;

	public static void main(String[] args) {
//		Book book = Book.builder()
//				.isbn("isbn1")
//				.author("author1")
//				.build();
		//System.out.println(book);
	}
}
