package org.lightvanko.dvdstore.persistences;

import org.lightvanko.dvdstore.data.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDao {

    @SuppressWarnings("unchecked")
    public List getAll() {
        return entityManager.createQuery("from User").getResultList();
    }

    public User getByUsername(String username) {
        return (User) entityManager.createQuery(
                "from User where username = :username")
                .setParameter("username", username)
                .getSingleResult();
    }

    public User getById(long id) {

        return entityManager.find(User.class, id);
    }

    @PersistenceContext
    private EntityManager entityManager;

}
