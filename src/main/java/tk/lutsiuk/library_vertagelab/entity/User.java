package tk.lutsiuk.library_vertagelab.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long userId;
	private String userName;
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<Book> userBooks = new HashSet<>();
	
}
