package be.wyrthh.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Course {

    @Id
    long id;
    String name;
    String description;
    String code;
    String imageURL;
    Boolean active;
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

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setModules(List<Exam> modules) {
        this.modules = modules;
    }
}
