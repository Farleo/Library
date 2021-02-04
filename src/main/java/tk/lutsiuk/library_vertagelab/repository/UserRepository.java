package tk.lutsiuk.library_vertagelab.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tk.lutsiuk.library_vertagelab.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

}
