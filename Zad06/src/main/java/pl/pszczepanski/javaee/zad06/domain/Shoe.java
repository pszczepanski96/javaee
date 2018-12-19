package pl.pszczepanski.javaee.zad06.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

@Entity
@NamedQueries({
        @NamedQuery(name = "shoe.getAll", query = "Select s from Shoe s"),
        @NamedQuery(name="shoe.deleteAll", query="Delete from Shoe"),
        @NamedQuery(name = "shoe.findById", query = "Select s from Shoe s where s.id = :id"),
})

public class Shoe {

    private long id;
    private String name;
    private double price;
    private int quantity;
    private Producer producer;


    public Shoe(){}

    public Shoe(String name, String producer, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }
}
