package pl.pszczepanski.javaee.zad05.domain;


import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

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
/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + yob;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (yob != other.yob)
			return false;
		return true;
	}
	*/

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
