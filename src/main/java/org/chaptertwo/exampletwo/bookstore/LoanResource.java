package org.chaptertwo.exampletwo.bookstore;

public class LoanResource {
	
	private String isbn;
	

	public void setIsbn(String isbn) {
		this.isbn=isbn;
		
	}
	
	public String getISBN() {
	 return isbn;	
	}

	@Override
	public String toString() {
		return "LoanResource [isbn=" + isbn + "]";
	}

}
