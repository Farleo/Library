package tk.lutsiuk.library_vertagelab.service;

public interface LibraryService {
	void takeBook(Long bookId, Long userId);
	
	void returnBook(Long bookId);
}
