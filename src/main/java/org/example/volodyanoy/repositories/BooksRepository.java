package org.example.volodyanoy.repositories;

import org.example.volodyanoy.models.Book;
import org.example.volodyanoy.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {
    List<Book> findByTitleStartingWith(String startingWith);

}
