package org.chaptertwo.exampletwo.bookstore;

import java.util.List;

import javax.inject.Inject;

public class LoanResource {
	
	@Inject
	Book book;
	
	List<Book> loanBooksCollection;
	
	public void addtoLoan() {
		loanBooksCollection.add(book);
	}
	

	
	public String verifyLoanDetails(String isbn) {
		
		Book book = loanBooksCollection.stream().filter(c -> c.getISBN().equals(isbn)).findAny()    // If 'findAny' then return found
                .orElse(null);
		if(book==null) {
			return " the book is not in  the loan ";
		}else
		return " This book is in the loan ";
		
		
	}

}
