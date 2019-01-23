package pl.pszczepanski.javaee.projekt.domain;

import javax.persistence.*;

@Entity
@NamedQuery(name = "owner.getAll", query = "SELECT o FROM Owner o")
public class Owner {

    private long id;
    private String name;
    private int yob;

    public Owner(String name, int yob) {
        this.name = name;
        this.yob = yob;
    }

    public Owner() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

}
