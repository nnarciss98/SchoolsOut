package be.wyrthh.model;

import javax.persistence.*;
import java.util.List;

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
    Course activeCourse;
    @ManyToMany
    List<Course> courseHistory;

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

    public Course getActiveCourse() {
        return activeCourse;
    }

    public List<Course> getCourseHistory() {
        return courseHistory;
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

    public Person setActiveCourse(Course course) {
        this.activeCourse = course;
        return this;
    }

    public Person setCourseHistory(List<Course> courseHistory) {
        this.courseHistory = courseHistory;
        return this;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", gender=" + gender +
                ", activeCourse=" + activeCourse +
                ", courseHistory=" + courseHistory +
                '}';
    }
}
