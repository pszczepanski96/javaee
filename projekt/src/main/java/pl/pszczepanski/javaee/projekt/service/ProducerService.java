package pl.pszczepanski.javaee.projekt.service;

import pl.pszczepanski.javaee.projekt.domain.Producer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ProducerService {

    @PersistenceContext
    EntityManager em;

    public void addProducer(Producer producer) {
        em.persist(producer);
    }

    public Producer getProducer(long id){
        return em.find(Producer.class, id);
    }

    public Producer updateProducer(Producer transientProducer) {
        return em.merge(transientProducer);
    }

    public void deleteProducer(long id){
        em.remove(em.find(Producer.class, id));
    }

    @SuppressWarnings("unchecked")
    public List<Producer> getAllProducer(){
        return em.createNamedQuery("producer.getAll").getResultList();
    }
}
