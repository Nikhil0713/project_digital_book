package com.digitalbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbook.entity.Book;
import com.digitalbook.repository.BookRepository;

@Service
public class BookServiceImpl implements IBookService {
	
	@Autowired
	private BookRepository repo;

	public Book save(Book book) {
		 Book savedBook = repo.save(book);
		return savedBook;
	}

	public Book update(Book book) {
		 Book updatedBook = repo.save(book);
		return updatedBook;
	}

	

	public Optional<Book> getBookById(Integer id) {
		Optional<Book> bookById = repo.findById(id);
		return bookById;
	}

	public String deleteUserById(Integer id) {
		repo.deleteById(id);
		return "Book got deleted sucessfully";
	}

	public List<Book> getAllBooks() {
		List<Book> findAllList = repo.findAll();
		return findAllList;
	}

	

	public List<Book> findByCategoryAndtitleAndAuthorAndPriceAndPublisher(String category, String title, String author,
			double price, String publisher) {
		List<Book> searchedBook = repo.findByCategoryAndTitleAndAuthorAndPriceAndPublisher(category, title, author, price, publisher);
		return searchedBook;
		
	}

	

}
