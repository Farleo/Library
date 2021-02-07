package tk.lutsiuk.library_vertagelab.service.impl;

import org.springframework.stereotype.Service;
import tk.lutsiuk.library_vertagelab.entity.Book;
import tk.lutsiuk.library_vertagelab.repository.BookRepository;
import tk.lutsiuk.library_vertagelab.service.BookService;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
	
	private final BookRepository bookRepository;
	
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	@Override
	public Book findBookById(Long id) {
		return bookRepository.findById(id).get();
	}
	
	@Override
	public List<Book> findAllBook() {
		return bookRepository.findAll();
	}
	
	@Override
	public void addNewBook(Book book) {
		Optional<Book> optionalBook = Optional.ofNullable(bookRepository.findByName(book.getName()));
		if (optionalBook.isEmpty()) {
			book.setAvailable(true);
			bookRepository.save(book);
		} else {
			throw new IllegalStateException("A book with this title name already exists");
		}
	}
	
	@Override
	public void deleteBook(Long id) {
		Book bookDB = bookRepository.findById(id).orElseThrow(() -> new IllegalStateException("There is no book that you want to delete"));
		bookRepository.delete(bookDB);
	}
	
	@Override
	public void editBook(Long id, Book book) {
		Book bookDB = bookRepository.findById(id).orElseThrow(() -> new IllegalStateException("There is no book that you want to edit"));
		bookDB.setName(book.getName());
		bookDB.setAuthor(book.getAuthor());
		bookRepository.save(bookDB);
	}
	
	@Override
	public void saveBook(Book bookDB) {
		bookRepository.save(bookDB);
	}
}
