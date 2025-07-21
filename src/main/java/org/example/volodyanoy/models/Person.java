package org.example.volodyanoy.models;



import javax.validation.constraints.*;

public class Person {
    private int id;

    @NotEmpty(message="Name should not be empty")
    @Size(min = 2, max = 50, message = "Name should be between 2 and 50 characters")
    private String name;

    @NotNull(message = "Year of birth should not be empty")
    @Min(value = 1900, message = "Year of birth should be greater than 1900")
    @Max(value = 2026, message = "Year of birth should be less than 2026")
    private Integer yearOfBirth;

    public Person(){}

    public Person(int id, String name, Integer yearOfBirth) {
        this.id = id;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
}
