package lucas.estudos.repository;

import lucas.estudos.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long > {
}
