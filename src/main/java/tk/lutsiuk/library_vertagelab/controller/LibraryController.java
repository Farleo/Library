package tk.lutsiuk.library_vertagelab.controller;

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
	public void takeBook(@RequestParam("bookId") Long bookId, @RequestParam("userId") Long userId) {
		libraryService.takeBook(bookId,userId);
	}
	
	@PostMapping(value = "/return")
	public void takeBook(@RequestParam("bookId") Long bookId) {
		libraryService.returnBook(bookId);
	}
}
