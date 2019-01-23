package pl.pszczepanski.javaee.zad05.domain;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Shoe {
	private long id;
	private String producer;

	private double price;
	private int quantity;
	private boolean waterproof;

	public Shoe(){}

	public Shoe(String producer, int quantity, double price, boolean waterproof) {
		this.producer = producer;
		this.quantity = quantity;
		this.price = price;
		this.waterproof = waterproof;

	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
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

	public boolean getWaterproof() {
		return waterproof;
	}

	public void setWaterproof(boolean waterproof) {
		this.waterproof = waterproof;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
