package org.chaptertwo.exampletwo.bookstore;

import java.util.ArrayList;
import java.util.List;

public class BookData {
	
	List<Book> books=new ArrayList<Book>();
	
    Book book;
	public void allBooks() {
		book=new Book();
		book.setAuthor(new Author("Ramesh",2));
		book.setISBN("GHZUZkj9865");

		books.add(book); // add book 1
		
		book=new Book();
		book.setAuthor(new Author("kamal",1));
		book.setISBN("GHZUZkj9875432");
		
		books.add(book); // add book 2
		
		book=new Book();
		book.setAuthor(new Author("parusam",3));
		book.setISBN("GHZU8964589432");
		
		books.add(book); // add book 3
	
	}
	
	public List<Book> getAllBooks() {
		 allBooks();
		return books;
		
	}

}
