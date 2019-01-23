package pl.pszczepanski.javaee.projekt.domain;

import javax.persistence.*;

@Entity
@NamedQuery(name = "producer.getAll", query = "select p from Producer p")
public class Producer {

    private long id;
    private String name;
    private String country;

    public Producer(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public Producer() {
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
