package org.example.volodyanoy.dao;

import org.example.volodyanoy.models.Book;
import org.example.volodyanoy.models.Person;
import org.hibernate.validator.constraints.pl.PESEL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {
    private  final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Book> index(){
        return jdbcTemplate.query("SELECT * FROM Book", new BookMapper());
    }

    public Optional<Book> show(String title, String author, int yearOfWriting){
        return jdbcTemplate.query("SELECT * FROM Book WHERE title = ? AND author = ? AND yearOfWriting = ?", new Object[]{title, author, yearOfWriting},
                new BookMapper()).stream().findAny();
    }

    public Book show(int id){
        return jdbcTemplate.query("SELECT * FROM Book WHERE book_id = ?", new Object[]{id},
                        new BookMapper())
                .stream().findAny().orElse(null);
    }

    public void save(Book book){
        jdbcTemplate.update("INSERT INTO Book(title, author, yearOfWriting) VALUES(?, ?, ?)", book.getTitle(),
                book.getAuthor(), book.getYearOfWriting());
    }

    public void update(int id, Book updatedBook){
        jdbcTemplate.update("UPDATE Book SET title=?, author=?, yearofwriting=? WHERE book_id=?",
                updatedBook.getTitle(), updatedBook.getAuthor(), updatedBook.getYearOfWriting(), id);
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM Book WHERE book_id=?", id);
    }

    //input id = person_id
    public List<Book> showBooksInPersonPossession(int id){
        return jdbcTemplate.query("SELECT book_id, title, author, yearofwriting\n" +
                "FROM book \n" +
                "WHERE book.person_id = ?", new Object[]{id}, new BookMapper());
    }

    public void releaseBook(int id){
        jdbcTemplate.update("UPDATE Book SET person_id = NULL WHERE book_id = ?", id);
    }

    public void assignBook(int book_id, int person_id){
        jdbcTemplate.update("UPDATE Book SET person_id = ? WHERE book_id = ?", person_id, book_id);
    }

}