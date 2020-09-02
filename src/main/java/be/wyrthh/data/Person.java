package be.wyrthh.data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {

    @Id
    int id;
    String firstName;
    String familyName;
    Gender gender;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
