package be.wyrthh.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Exam {

    @Id
    long id;
    String name;
    String description;
    LocalDate date;
    int weight;
    int total;
    Exam module;

    /* Getters for the Exam object */

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getWeight() {
        return weight;
    }

    public int getTotal() {
        return total;
    }

    public Exam getModule() {
        return module;
    }

    /* Setters for the Exam object */

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setModule(Exam module) {
        this.module = module;
    }
}
