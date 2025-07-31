package org.example.volodyanoy.LibrarySpringBootApp.util;

import org.example.volodyanoy.LibrarySpringBootApp.dao.BookDAO;
import org.example.volodyanoy.LibrarySpringBootApp.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class BookValidator implements Validator {
    private final BookDAO bookDAO;

    @Autowired
    public BookValidator(BookDAO bookDAO){
        this.bookDAO = bookDAO;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Book.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Book book = (Book) o;

/*        if(bookDAO.show(book.getTitle(), book.getAuthor(), book.getYearOfWriting()).isPresent()){
            errors.rejectValue("title", "", "This title, author and year of writing is already taken (Такая книга уже существует!)");
        }*/

    }
}
