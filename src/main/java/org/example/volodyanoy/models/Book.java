package org.example.volodyanoy.models;

public class Book {
    private int id;
    private String title;
    private String author;
    private int yearOfWrining;

    public Book(int id, String title, String author, int yearOfWrining){
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearOfWrining = yearOfWrining;
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

    public int getYearOfWrining() {
        return yearOfWrining;
    }

    public void setYearOfWrining(int yearOfWrining) {
        this.yearOfWrining = yearOfWrining;
    }
}
