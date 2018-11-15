package pl.pszczepanski.javaee.zad03.domain;

import java.sql.*;

public class Shoe {
	private String producer;
	private Date productionDate;
	private double price;
	private int quantity;
	private boolean waterproof;
	public Shoe(String producer, Date productionDate, int quantity, double price, boolean waterproof) {
		this.producer = producer;
		this.productionDate = productionDate;
		this.quantity = quantity;
		this.price = price;
		this.waterproof = waterproof;

	}

	public Shoe(String producer, java.util.Date productionDate, double quantity, double price, boolean waterproof) {

	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public Date getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
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
}