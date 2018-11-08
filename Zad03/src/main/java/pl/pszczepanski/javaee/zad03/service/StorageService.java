package pl.pszczepanski.javaee.zad03.service;

import java.util.ArrayList;
import java.util.List;

import pl.pszczepanski.javaee.zad03.domain.Shoe;

public class StorageService {
	
	private List<Shoe> db = new ArrayList<Shoe>();
	
	public void add(Shoe shoe){
		Shoe newShoe = new Shoe(shoe.getProducer(),shoe.getProductionDate(),shoe.getQuantity(),shoe.getPrice(),shoe.getWaterproof());
		db.add(newShoe);
	}
	
	public List<Shoe> getAllShoes(){
		return db;
	}

}
