package tk.lutsiuk.library_vertagelab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.lutsiuk.library_vertagelab.entity.Book;
import tk.lutsiuk.library_vertagelab.service.BookService;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "/{id}")
	public Book getBook(@PathVariable Long id) {
		return bookService.findBookById(id);
	}
	
	@RequestMapping(value = "/all")
	public List<Book> getAllBook() {
		return bookService.findAllBook();
	}
	
}
