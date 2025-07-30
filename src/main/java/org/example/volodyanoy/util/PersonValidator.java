package org.example.volodyanoy.util;

import org.example.volodyanoy.dao.PersonDAO;
import org.example.volodyanoy.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {
    private final PersonDAO personDAO;

    @Autowired
    public PersonValidator(PersonDAO personDAO){
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;

/*        if(personDAO.show(person.getName(), person.getYearOfBirth()).isPresent()){
            errors.rejectValue("name", "", "This name and year of birth is already taken (Такой пользователь уже существует!)");
        }*/

    }
}
