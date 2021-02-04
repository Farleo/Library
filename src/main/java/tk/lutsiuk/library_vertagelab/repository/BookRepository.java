package tk.lutsiuk.library_vertagelab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tk.lutsiuk.library_vertagelab.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
