package be.wyrthh.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "exam")
public class Exam {

    @Id
    @GeneratedValue
    long id;
    String name;
    String description;
    LocalDate date;
    int weight;
    int total;
    @ManyToOne
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

    public Exam setId(long id) {
        this.id = id;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Exam setDescription(String description) {
        this.description = description;
        return this;
    }

    public Exam setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public Exam setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public Exam setTotal(int total) {
        this.total = total;
        return this;
    }

    public Exam setModule(Exam module) {
        this.module = module;
        return this;
    }
}
