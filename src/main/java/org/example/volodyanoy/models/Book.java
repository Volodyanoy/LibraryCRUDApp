package org.example.volodyanoy.models;

import javax.validation.constraints.*;

public class Book {
    private int id;
    
    @NotEmpty
    @Size(min = 2, max = 50, message = "Title should be between 2 and 50 characters")
    private String title;
    
    @NotEmpty
    @Size(min = 2, max = 50, message = "Name author should be between 2 and 50 characters")
    private String author;
    
    @NotNull
    @Min(value = 1700, message = "Year of birth should be greater than 1700")
    @Max(value = 2026, message = "Year of birth should be less than 2026")
    private Integer yearOfWriting;
    
    public Book(){}

    public Book(int id, String title, String author, Integer yearOfWriting){
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearOfWriting = yearOfWriting;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYearOfWriting() {
        return yearOfWriting;
    }

    public void setYearOfWriting(Integer yearOfWriting) {
        this.yearOfWriting = yearOfWriting;
    }
}
