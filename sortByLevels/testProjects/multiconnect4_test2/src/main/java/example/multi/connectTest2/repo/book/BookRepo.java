package example.multi.connectTest2.repo.book;

import example.multi.connectTest2.model.book.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book,Long> {
}
