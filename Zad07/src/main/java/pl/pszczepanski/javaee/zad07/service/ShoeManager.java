package pl.pszczepanski.javaee.zad07.service;

import pl.pszczepanski.javaee.zad07.domain.Shoe;

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
        Shoe result = getShoeById(id);
         return result;
     }
     public void deleteAllShoes(){
        sm.createNamedQuery("shoe.deleteAll").executeUpdate();
     }



    @SuppressWarnings("unchecked")
    public List<Shoe> getAllShoes(){
        return sm.createNamedQuery("shoe.getAll").getResultList();
    }


}
