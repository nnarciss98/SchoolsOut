package be.wyrthh.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "module")
public class Module {

    @Id
    @GeneratedValue
    long id;
    String name;
    String description;
    @ManyToOne
    Course course;
    @OneToMany
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

    public Module setId(long id) {
        this.id = id;
        return this;
    }

    public Module setName(String name) {
        this.name = name;
        return this;
    }

    public Module setDescription(String description) {
        this.description = description;
        return this;
    }

    public Module setCourse(Course course) {
        this.course = course;
        return this;
    }

    public Module setExams(List<Exam> exams) {
        this.exams = exams;
        return this;
    }

    @Override
    public String toString() {
        return "Module{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", course=" + course +
                ", exams=" + exams +
                '}';
    }
}
