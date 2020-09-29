package be.wyrthh.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    private String login;
    private String passwordHash;
    private Boolean active;
    @OneToOne
    private Person person;

    /* Getters for the User */

    public String getLogin() {
        return login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public Boolean getActive() {
        return active;
    }

    public Person getPerson() {
        return person;
    }

    /* Setters for the User */

    public User setLogin(String login) {
        this.login = login;
        return this;
    }

    public User setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
        return this;
    }

    public User setActive(Boolean active) {
        this.active = active;
        return this;
    }

    public User setPerson(Person person) {
        this.person = person;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", active=" + active +
                ", person=" + person +
                '}';
    }
}
