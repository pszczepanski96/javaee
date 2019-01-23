package pl.pszczepanski.javaee.projekt.domain;

import javax.persistence.*;

@Entity
@NamedQuery(name = "serial.getAll", query = "select s from Serial s")
public class Serial {

    private long id;
    private String serialNr;

    public Serial(String serialNr) {
        this.serialNr = serialNr;
    }

    public Serial() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSerialNr() {
        return serialNr;
    }

    public void setSerialNr(String serialNr) {
        this.serialNr = serialNr;
    }
}
