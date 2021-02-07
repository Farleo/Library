package tk.lutsiuk.library_vertagelab.service.impl;

import org.springframework.stereotype.Service;
import tk.lutsiuk.library_vertagelab.entity.Book;
import tk.lutsiuk.library_vertagelab.entity.User;
import tk.lutsiuk.library_vertagelab.service.BookService;
import tk.lutsiuk.library_vertagelab.service.LibraryService;
import tk.lutsiuk.library_vertagelab.service.UserService;

import java.util.Optional;

@Service
public class LibraryServiceImpl implements LibraryService {
	
	private final BookService bookService;
	private final UserService userService;
	
	public LibraryServiceImpl(BookService bookService, UserService userService) {
		this.bookService = bookService;
		this.userService = userService;
	}
	
	@Override
	public void takeBook(Long bookId, Long userId) {
		Book bookDB = Optional.ofNullable(bookService.findBookById(bookId)).orElseThrow(() -> new IllegalStateException("There is no book that you want to take"));
		if (bookDB.isAvailable()) {
			User userDB = userService.findUserById(userId);
			bookDB.setAvailable(false);
			bookDB.setUser(userDB);
			bookService.saveBook(bookDB);
		} else throw new IllegalStateException("There is already taken");
	}
	
	@Override
	public void returnBook(Long bookId) {
		Book bookDB = Optional.ofNullable(bookService.findBookById(bookId)).orElseThrow(() -> new IllegalStateException("There is no book that you want to return"));
		if (!bookDB.isAvailable()) {
			bookDB.setAvailable(true);
			bookDB.setUser(null);
			bookService.saveBook(bookDB);
		} else throw new IllegalStateException("This book was not taken");
	}
}
