package classes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.util.Objects;

public class Cat {
    private String name;
    private int age;
    private String color;
//    @JsonIgnore
    private LocalDateTime dateOfBirth;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return age == cat.age && name.equals(cat.name) && color.equals(cat.color) && Objects.equals(dateOfBirth, cat.dateOfBirth);
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Cat cat = (Cat) o;
//        return age == cat.age && name.equals(cat.name) && color.equals(cat.color) && dateOfBirth.equals(cat.dateOfBirth);
//    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, color, dateOfBirth);
    }

    public void setDateOfBirth(LocalDateTime now) {
        this.dateOfBirth = now;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }
}
