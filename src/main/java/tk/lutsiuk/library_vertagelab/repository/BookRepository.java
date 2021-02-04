package tk.lutsiuk.library_vertagelab.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tk.lutsiuk.library_vertagelab.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

}
