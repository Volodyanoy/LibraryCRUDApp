package org.example.volodyanoy.services;

import org.example.volodyanoy.models.Book;
import org.example.volodyanoy.models.Person;
import org.example.volodyanoy.repositories.BooksRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BooksService {
    private final BooksRepository booksRepository;


    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> findAll(){
        return booksRepository.findAll();
    }

    public List<Book> findAllAndSortByYearOfWriting(){
        return booksRepository.findAll(Sort.by("yearOfWriting"));
    }

    public List<Book> findAllAndPagination(Integer page, Integer booksPerPage){
        return booksRepository.findAll(PageRequest.of(page, booksPerPage)).getContent();
    }

    public List<Book> findAllAndSortByYearOfWritingAndPagination(Integer page, Integer booksPerPage){
        return booksRepository.findAll(PageRequest.of(page, booksPerPage, Sort.by("yearOfWriting"))).getContent();
    }

    public Book findOne(int id){
        Optional<Book> foundBook = booksRepository.findById(id);
        return foundBook.orElse(null);
    }

    @Transactional
    public void save(Book book){
        booksRepository.save(book);
    }

    @Transactional
    public void update(int id, Book updatedBook){
        updatedBook.setId(id);
        booksRepository.save(updatedBook);
    }

    @Transactional
    public void delete(int id){
        booksRepository.deleteById(id);
    }

    public Person getOwnerOfBook(int id){
        return booksRepository.findById(id).map(Book::getOwner).orElse(null);
    }

    @Transactional
    public void releaseBook(int id){
        booksRepository.findById(id).ifPresent(book -> {
            Person owner = book.getOwner();
            if(owner != null)
                owner.removeBook(book);
        });
    }

    @Transactional
    public void assignBook(int id, Person person){
        booksRepository.findById(id).ifPresent(book -> {
            Person oldOwner = book.getOwner();
            if(oldOwner != null)
                oldOwner.removeBook(book);
            person.addBook(book);
        });
    }


}
