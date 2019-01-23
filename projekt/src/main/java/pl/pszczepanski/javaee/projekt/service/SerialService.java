package pl.pszczepanski.javaee.projekt.service;

import pl.pszczepanski.javaee.projekt.domain.Serial;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class SerialService {

    @PersistenceContext
    EntityManager em;

    public void addSerial(Serial serial) {
        em.persist(serial);
    }

    public Serial getSerial(long id){
        return em.find(Serial.class, id);
    }

    public Serial updateSerial(Serial transientSerial) {
        return em.merge(transientSerial);
    }

    public void deleteSerial(long id){
        em.remove(em.find(Serial.class, id));
    }

    @SuppressWarnings("unchecked")
    public List<Serial> getAllSerial(){
        return em.createNamedQuery("serial.getAll").getResultList();
    }
}
