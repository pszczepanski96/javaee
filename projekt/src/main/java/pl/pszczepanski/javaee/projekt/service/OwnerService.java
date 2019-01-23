package pl.pszczepanski.javaee.projekt.service;

import pl.pszczepanski.javaee.projekt.domain.Owner;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class OwnerService {

    @PersistenceContext
    EntityManager em;

    public void addOwner(Owner owner) {
        em.persist(owner);
    }

    public Owner getOwner(long id){
        return em.find(Owner.class, id);
    }

    public Owner updateOwner(Owner transientOwner) {
        return em.merge(transientOwner);
    }

    public void deleteOwner(long id){
        em.remove(em.find(Owner.class, id));
    }

    @SuppressWarnings("unchecked")
    public List<Owner> getAllOwner(){
        return em.createNamedQuery("owner.getAll").getResultList();
    }
}
