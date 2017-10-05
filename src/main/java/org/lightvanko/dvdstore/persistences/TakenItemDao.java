package org.lightvanko.dvdstore.persistences;

import org.lightvanko.dvdstore.data.TakenItem;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class TakenItemDao {

    @SuppressWarnings("unchecked")
    public List getAll() {
        return entityManager.createQuery("from TakenItem")
                .getResultList();
    }

    public TakenItem getById(long id) {
        return entityManager.find(TakenItem.class, id);
    }

    @SuppressWarnings("unchecked")
    public List getTakenByUserItems(long userId) {
        return entityManager.createQuery("from TakenItem where user.id = :userId")
                .setParameter("userId", userId)
                .getResultList();
    }

    @SuppressWarnings("unchecked")
    public List getGivenByUserItems(long userId) {
        return entityManager.createQuery("from TakenItem where disk.user.id = :userId")
                .setParameter("userId", userId)
                .getResultList();
    }

    @Transactional
    public void create(TakenItem takenItem) {
        entityManager.persist(takenItem);
        return;
    }

    @Transactional
    public void delete(TakenItem takenItem) {
        if (entityManager.contains(takenItem))
            entityManager.remove(takenItem);
        else
            entityManager.remove(entityManager.merge(takenItem));
        return;
    }

    @PersistenceContext
    private EntityManager entityManager;
}
