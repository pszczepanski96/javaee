package pl.pszczepanski.javaee.zad06.service;

import pl.pszczepanski.javaee.zad06.domain.Shoe;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ShoeManager {

    @PersistenceContext
    EntityManager sm;

    public void addShoe(Shoe shoe){
        sm.persist(shoe);
    }
     public Shoe getShoeById(long id){
        return sm.find(Shoe.class, id);
     }
     public void deleteAllShoes(){
        sm.createNamedQuery("shoe.deleteAll").executeUpdate();
     }
     public Shoe updateShoe(Shoe transientShoe){
        return  sm.merge(transientShoe);
     }

     @SuppressWarnings("unchecked")
    public List<Shoe> getAllShoes(){
        return sm.createNamedQuery("shoe.getAll").getResultList();
    }


}
