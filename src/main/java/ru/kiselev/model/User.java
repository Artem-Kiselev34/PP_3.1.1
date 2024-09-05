package ru.kiselev.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @NotNull(message = "Name cannot be null")
    @Size(min = 2, max = 20, message = "Имя должно содержать от 2х до 20 букв")
    @Pattern(regexp = "^[a-zA-Zа-яА-ЯёЁ]*$", message = "Имя должно содержать только буквы")
    private String name;

    @NotNull(message = "Surname cannot be null")
    @Size(min = 2, max = 20, message = "Фамилия должна содержать от 2х до 20 букв")
    @Pattern(regexp = "^[a-zA-Zа-яА-ЯёЁ]*$", message = "Фамилия должна содержать только буквы")
    private String surname;

    @Min(value = 0, message = "Возраст не должен быть меньше 0")
    @Max(value = 150, message = "Возраст не должен быть больше 150 лет")
    private int age;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public User(String name, String surname, int age) {

        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
