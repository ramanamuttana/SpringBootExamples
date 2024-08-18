package org.chaptertwo.exampletwo.bookstore;

import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;

import org.springframework.stereotype.Repository;

@Repository
public class Bookshelf {
	

	@Inject 
	BookData bookdata;
	
	/*
	 * get all the books from the database
	 */
	public List<Book> findAll() {
		

		List<Book> booksCollection = bookdata.getAllBooks();

		return booksCollection;
	}

	/*
	 * stream all the books , filter isbn , collect that matches
	 */
	public Book findByISBN(String isbn) {

		Book book = (Book) findAll().stream().filter(c -> c.getISBN().equals(isbn)).findAny()     // If 'findAny' then return found
                .orElse(null);
		return book;
	}

	/*
	 * save the new values in the database
	 * incomplete
	 */
	public void create(Book book) {
		book.setAuthor(book.getAuthor());
		book.setISBN(book.getISBN());

	}

	public boolean exists(Object isbn) {
		Book book = (Book) findAll().stream().filter(c -> c.getISBN().equals(isbn)).collect(Collectors.toList());
		if (book != null) {
			return true;
		}
		return false;
	}

	public void update(String isbn, Book book) {

	}

	/*
	 * delete the isbn value 
	 */
	public void delete(String isbn) {
		findAll()
		.stream()
		.filter(c-> c.getISBN().equals(isbn))
		.collect(Collectors.toList())
		.remove(0);

	}

}
