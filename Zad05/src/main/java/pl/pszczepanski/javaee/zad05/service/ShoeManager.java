
package pl.pszczepanski.javaee.zad05.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.ejb.Singleton;


import pl.pszczepanski.javaee.zad05.domain.Shoe;

@Singleton
public class ShoeManager {
	
	private List<Shoe> db = Collections.synchronizedList(new ArrayList<>());

	public void addShoe(Shoe shoe) {
		db.add(shoe);
	}

	public void deletePerson(Shoe shoe){
		db.remove(shoe);
 	}
	
	public Shoe getShoe(Integer id) {
		return new Shoe("Nike", 3, 115.00, true);
	}
	
	public List<Shoe> getAllShoes(){
		return db;
	}
	
	public void deleteAllShoes(){
		db.clear();
	}

}
