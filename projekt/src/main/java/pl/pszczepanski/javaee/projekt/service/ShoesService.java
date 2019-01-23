package pl.pszczepanski.javaee.projekt.service;

import pl.pszczepanski.javaee.projekt.domain.Shoes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ShoesService {

    @PersistenceContext
    EntityManager em;

    public void addShoes(Shoes shoes) {
        em.persist(shoes);
    }

    public Shoes getShoes(long id){
        return em.find(Shoes.class, id);
    }

    public Shoes updateShoes(Shoes transientShoes) {
        return em.merge(transientShoes);
    }

    public void deleteShoes(long id){
        em.remove(em.find(Shoes.class, id));
    }

    @SuppressWarnings("unchecked")
    public List<Shoes> getAllShoes(){
        return em.createNamedQuery("shoes.getAll").getResultList();
    }
}
