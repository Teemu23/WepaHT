

package wad.booklibrary.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import wad.booklibrary.Book;



public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE b.name LIKE ?1")
    List<Book> findByPartOfName(String name);
    @Query("SELECT b FROM Book b WHERE b.authors LIKE ?1")
    List<Book> findByPartOfAuthor(String author);
    
}
