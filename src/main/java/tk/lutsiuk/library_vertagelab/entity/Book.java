package tk.lutsiuk.library_vertagelab.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
public class Book {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long bookId;
	private String name;
	private boolean isAvailable;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
}
