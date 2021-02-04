package tk.lutsiuk.library_vertagelab.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.lutsiuk.library_vertagelab.entity.Book;
import tk.lutsiuk.library_vertagelab.repository.BookRepository;
import tk.lutsiuk.library_vertagelab.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public Book findBookById(Long id) {
		return bookRepository.findById(id).get();
	}
	
	@Override
	public List<Book> findAllBook() {
		return bookRepository.findAll();
	}
}
