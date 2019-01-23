package pl.pszczepanski.javaee.zad04.service;

import java.util.ArrayList;
import java.util.List;

import pl.pszczepanski.javaee.zad04.domain.Shoe;

public class StorageService {

	private int id = 0;
	private List<Shoe> db = new ArrayList<Shoe>();
	private List<Shoe> basket = new ArrayList<Shoe>();
	private boolean rodo;

	public void add(Shoe shoe){
		Shoe newShoe = new Shoe(shoe.getId(), shoe.getProducer(),shoe.getProductionDate(),shoe.getQuantity(),shoe.getPrice(),shoe.getWaterproof());
		db.add(newShoe);
	}

	public int getId(){
		id++;
		return this.id;
	}

	public void addToBasket(Shoe shoe){

		basket.add(shoe);
	}

	public List<Shoe> getAllShoes(){
		return db;
	}

	public List<Shoe> getBasket(){
		return basket;

	}

	public void setRodoStatus(String rodo) {
		if("on".equals(rodo)) {
			this.rodo = true;
		} else {
			this.rodo = false;
		}
//
	}

	public boolean getRodoStatus() {
		return rodo;
	}

}