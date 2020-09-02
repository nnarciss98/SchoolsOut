package be.wyrthh.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Module {

    @Id
    long id;
    String name;
    String description;
    Course course;
    List<Exam> exams;

    /* Getters for the Module object */

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Course getCourse() {
        return course;
    }

    public List<Exam> getExams() {
        return exams;
    }

    /* Setters for the Module object */

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }
}
