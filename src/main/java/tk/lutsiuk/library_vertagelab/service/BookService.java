package tk.lutsiuk.library_vertagelab.service;

import tk.lutsiuk.library_vertagelab.entity.Book;

import java.util.List;

public interface BookService {
	Book findBookById(Long id);
	
	List<Book> findAllBook();
}
