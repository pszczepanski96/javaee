package pl.pszczepanski.javaee.zad06.service;

import pl.pszczepanski.javaee.zad06.domain.Producer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ProducerManager {
    @PersistenceContext
    EntityManager sm;

    public void addProducer(Producer producer){
        sm.persist(producer);
    }
    public Producer getProducerById(long id){
        return sm.find(Producer.class, id);
    }
    public void deleteAllProducers(){
        sm.createNamedQuery("producer.deleteAll").executeUpdate();
    }
    public Producer updateProducer(Producer transientProducer){
        return  sm.merge(transientProducer);
    }

    @SuppressWarnings("unchecked")
    public List<Producer> getAllProducers(){
        return sm.createNamedQuery("producer.getAll").getResultList();
    }

}
