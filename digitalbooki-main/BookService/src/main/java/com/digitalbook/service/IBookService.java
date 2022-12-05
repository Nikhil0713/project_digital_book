package com.digitalbook.service;

import java.util.List;
import java.util.Optional;

import com.digitalbook.entity.Book;

public interface IBookService {
	
	//save 
	
	public Book save(Book book );
	
	//update
	
	public Book update(Book book);
	
	//get all books list
	
	public List<Book> getAllBooks();
	
	//get single book using pk
	
	public Optional<Book> getBookById(Integer id);
	
	//delete the book based on pk
	
	public String deleteUserById(Integer id);
	
	
	public List<Book> findByCategoryAndtitleAndAuthorAndPriceAndPublisher(String category ,String title ,String author,  double price,String publisher);
	 
	

}
