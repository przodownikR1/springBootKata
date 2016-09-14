package pl.java.scalatech.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

    Book findByAuthor(String author); //by method
    
    //jpql
    
    //Book findByAuthorByJQL(String author);
    //native sql
    
    //custom repo 
    
   
    
    
    
}
