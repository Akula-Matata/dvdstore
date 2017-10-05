package org.lightvanko.dvdstore.persistences;

import org.lightvanko.dvdstore.data.Disk;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class DiskDao {

    @SuppressWarnings("unchecked")
    public List getAll() {
        return entityManager.createQuery("from Disk").getResultList();
    }

    @SuppressWarnings("unchecked")
    public List getNotTakenItems() {
        return entityManager.createQuery("from Disk where id not in (select distinct disk.id from TakenItem)").getResultList();
    }

    public Disk getById(long id) {
        return entityManager.find(Disk.class, id);
    }

    @Transactional
    public void create(Disk disk) {
        entityManager.persist(disk);
        return;
    }

    @PersistenceContext
    private EntityManager entityManager;
}
