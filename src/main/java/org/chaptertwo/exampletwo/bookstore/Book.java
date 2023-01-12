package org.chaptertwo.exampletwo.bookstore;

public class Book {
	
	
	private String isbn;
	private Author author ;
	
	public Book() {
		
	}
	
	public void setISBN(String isbn) {
		this.isbn=isbn;
	}

	public String getISBN() {
		return isbn;
	}
	
	public void setAuthor(Author author ) {
		this.author=author;
	}

	public Author getAuthor() {
		
		return author;
	}

}
