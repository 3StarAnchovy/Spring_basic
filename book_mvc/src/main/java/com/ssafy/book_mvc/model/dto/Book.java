package com.ssafy.book_mvc.model.dto;

public class Book {
	private String isbn;
	private String title;
	private int price;
	private String desc;
	private String author;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Book(String isbn, String title, int price, String desc, String author) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.desc = desc;
		this.author = author;
	}

	public Book() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", price=" + price + ", desc=" + desc + ", author=" + author
				+ "]";
	}

}
