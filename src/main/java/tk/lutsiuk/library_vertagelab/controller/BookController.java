package tk.lutsiuk.library_vertagelab.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tk.lutsiuk.library_vertagelab.entity.Book;
import tk.lutsiuk.library_vertagelab.service.BookService;

import java.util.List;

@RestController
@RequestMapping(value = "/book", produces = {MediaType.APPLICATION_JSON_VALUE})
public class BookController {

	private final BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Get certain book")
	public Book getBook(@PathVariable Long id) {
		return bookService.findBookById(id);
	}
	
	@GetMapping(value = "/all")
	@ApiOperation(value = "Get all book")
	public List<Book> getAllBook() {
		return bookService.findAllBook();
	}
	
	@PostMapping(value = "/add")
	@ApiOperation(value = "Create new book")
	public void addNewBook(@RequestBody Book book){
		bookService.addNewBook(book);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	@ApiOperation(value = "Delete certain book")
	public void deleteBook(@PathVariable Long id){
		bookService.deleteBook(id);
	}
	
	@PutMapping(value = "/edit/{id}")
	@ApiOperation(value = "Modify certain book")
	public void editBook(@PathVariable Long id, @RequestBody Book book){
		bookService.editBook(id, book);
	}
}
