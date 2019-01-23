
package pl.pszczepanski.javaee.zad05.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import pl.pszczepanski.javaee.zad05.domain.Shoe;

@Stateless
public class ShoeManager {

	private List<Shoe> db = Collections.synchronizedList(new ArrayList<>());


	public void addShoe(Shoe shoe) {
		db.add(shoe);
	}

	public void deleteShoe(Shoe shoe){
		db.remove(shoe);
	}

	public void deleteAllShoe(){
		db.clear();
 	}
	
	public Shoe getShoe(Integer id) {
		return new Shoe("Nike", 3, 115.00, true);
	}
	
	public List<Shoe> getAllShoes(){
		return db;
	}

}
