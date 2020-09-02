package be.wyrthh.data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    String login;
    String passwordHash;
    Boolean active;
    Person person;

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

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
