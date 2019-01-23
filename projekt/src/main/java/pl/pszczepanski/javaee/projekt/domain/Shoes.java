package pl.pszczepanski.javaee.projekt.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name = "shoes.getAll", query = "select s from Shoes s")
public class Shoes {

    private long id;
    private String name;
    private int size;

    private Producer company;
    private Serial serialNumber;
    private List<Owner> wearers = new ArrayList<Owner>();

    public Shoes(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public Shoes() {
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Producer getCompany() {
        return company;
    }

    public void setCompany(Producer company) {
        this.company = company;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Serial getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Serial serialNumber) {
        this.serialNumber = serialNumber;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Owner> getWearers() {
        return wearers;
    }

    public void setWearers(List<Owner> wearers) {
        this.wearers = wearers;
    }
}
