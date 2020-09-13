package be.wyrthh.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue
    long id;
    String name;
    String description;
    String code;
    String imageURL;
    Boolean active;
    @OneToMany
    List<Exam> modules;


    /* Getters for the object properties */

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCode() {
        return code;
    }

    public String getImageURL() {
        return imageURL;
    }

    public Boolean getActive() {
        return active;
    }

    public List<Exam> getModules() {
        return modules;
    }


    /* Setters for the object properties */

    public Course setId(long id) {
        this.id = id;
        return this;
    }

    public Course setName(String name) {
        this.name = name;
        return this;
    }

    public Course setDescription(String description) {
        this.description = description;
        return this;
    }

    public Course setCode(String code) {
        this.code = code;
        return this;
    }

    public Course setImageURL(String imageURL) {
        this.imageURL = imageURL;
        return this;
    }

    public Course setActive(Boolean active) {
        this.active = active;
        return this;
    }

    public Course setModules(List<Exam> modules) {
        this.modules = modules;
        return this;
    }
}
