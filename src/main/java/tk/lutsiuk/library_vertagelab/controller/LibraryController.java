package tk.lutsiuk.library_vertagelab.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tk.lutsiuk.library_vertagelab.service.LibraryService;

@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
public class LibraryController {
	
	private final LibraryService libraryService;
	
	public LibraryController(LibraryService libraryService) {
		this.libraryService = libraryService;
	}
	
	@PostMapping(value = "/take")
	@ApiOperation(value = "Certain user take certain book")
	public void takeBook(@RequestParam("bookId") Long bookId, @RequestParam("userId") Long userId) {
		libraryService.takeBook(bookId,userId);
	}
	
	@PostMapping(value = "/return")
	@ApiOperation(value = "Certain user return certain book")
	public void returnBook(@RequestParam("bookId") Long bookId) {
		libraryService.returnBook(bookId);
	}
}
