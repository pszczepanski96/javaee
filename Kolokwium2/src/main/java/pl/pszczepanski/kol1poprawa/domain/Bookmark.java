package pl.pszczepanski.kol1poprawa.domain;

public class Bookmark {
    private int id;
    private String name;
    private String date;
    private String color;
    private String extras;
    private int price;
    private int quantity;

    public Bookmark() {
    }

    public Bookmark(int id, String name, String date, String color, String extras, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.color = color;
        this.extras = extras;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
