package be.wyrthh.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="grade")
public class Grade {

    @Id
    @GeneratedValue
    long id;
    @ManyToOne
    Person person;
    @ManyToOne
    Exam exam;
    BigDecimal gradeValue;
    String comment;
    String internalComment;
    Boolean absent;
    Boolean postponed;
    LocalDate date;

    /* Getters for the grade object */

    public long getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public Exam getExam() {
        return exam;
    }

    public BigDecimal getGradeValue() {
        return gradeValue;
    }

    public String getComment() {
        return comment;
    }

    public String getInternalComment() {
        return internalComment;
    }

    public Boolean getAbsent() {
        return absent;
    }

    public Boolean getPostponed() {
        return postponed;
    }

    public LocalDate getDate() {
        return date;
    }

    /* Setters for the grade object */

    public Grade setId(long id) {
        this.id = id;
        return this;
    }

    public Grade setPerson(Person person) {
        this.person = person;
        return this;
    }

    public Grade setExam(Exam exam) {
        this.exam = exam;
        return this;
    }

    public Grade setGradeValue(BigDecimal gradeValue) {
        this.gradeValue = gradeValue;
        return this;
    }

    public Grade setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public Grade setInternalComment(String internalComment) {
        this.internalComment = internalComment;
        return this;
    }

    public Grade setAbsent(Boolean absent) {
        this.absent = absent;
        return this;
    }

    public Grade setPostponed(Boolean postponed) {
        this.postponed = postponed;
        return this;
    }

    public Grade setDate(LocalDate date) {
        this.date = date;
        return this;
    }
}
