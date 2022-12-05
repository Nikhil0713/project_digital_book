package com.digitalbook.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbook.entity.Book;
import com.digitalbook.service.IBookService;
import com.digitalbook.utility.BookException;



@RestController
@RequestMapping("BM")
public class BookRestController {
	
	@Autowired
	private IBookService service;
	
	@GetMapping("/allBooks")
	public ResponseEntity<List<Book>> getAllBooks() throws BookException
	{
		try {
			List<Book> allBooks = service.getAllBooks();
			return ResponseEntity.status(200).body(allBooks);
		}
		catch (Exception e) {
			 throw new BookException("Invalid Request");
		}
		
	}
	@GetMapping("/getBookById/{id}")
	public ResponseEntity<Book> getBookId( @PathVariable Integer id) throws BookException
	{
		
		
		Optional<Book> bookById = service.getBookById(id);
		if(bookById.isPresent())
			return ResponseEntity.status(200).body(bookById.get());
		else {
			throw new BookException("Invalid Request");
			}
		
		
	}
	
	@PostMapping("/insertBook")
	public ResponseEntity<Book> saveBook(@RequestBody Book book) throws BookException
	{
		try {
			Book save = service.save(book);
			return ResponseEntity.status(200).body(save);
		}catch (Exception e) {
			throw new BookException("Data IS inavalid ");
		}
		
		
	}
	
	@PostMapping("/updateBook")
	public ResponseEntity<Book> updateBook(@RequestBody Book book) throws BookException
	{
		try {
			Book update = service.update(book);
			return ResponseEntity.status(200).body(update);
		}catch (Exception e) {
			throw new BookException("Data IS inavalid ");
		}
		
		
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable Integer id) throws Exception{
		try {
		String deleteUserById = service.deleteUserById(id);
		return ResponseEntity.status(200).body(deleteUserById);
		}
		catch(Exception e) {
			throw new BookException("Data IS inavalid ");
		}
	}
	
	
	@GetMapping("/search/{category}/{title}/{author}/{publisher}")
	public ResponseEntity<List<Book>> getBookByCattegoryTitleAuthorPublisher(@PathVariable(value = "category") String category, @PathVariable(value = "title") String title,@PathVariable(value = "author") String author,
			@PathVariable(value = "price") double price, @PathVariable(value = "publisher") String publisher) throws BookException{
		try {
		List<Book> searchedBook = service.findByCategoryAndtitleAndAuthorAndPriceAndPublisher(category, title, author, price, publisher);
		return ResponseEntity.status(200).body(searchedBook);
		}catch (Exception e) {
			throw new BookException("Data IS inavalid ");
		}
	}

}
