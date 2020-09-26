package be.wyrthh.model;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue
    int id;
    String firstName;
    String familyName;
    @Enumerated(EnumType.STRING)
    Gender gender;
    @ManyToOne
    Course course;

    /* Getters for Person */

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public Gender getGender() {
        return gender;
    }

    public Course getCourse() {
        return course;
    }

    /* Setters for person */

    public Person setId(int id) {
        this.id = id;
        return this;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Person setFamilyName(String familyName) {
        this.familyName = familyName;
        return this;
    }

    public Person setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Person setCourse(Course course) {
        this.course = course;
        return this;
    }
}
