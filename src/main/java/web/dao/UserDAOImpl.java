package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
@Repository
@Component
public class UserDAOImpl implements UserDAO{
    @PersistenceContext
    private EntityManager entityManager;



    public List<User> index() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    public User show(long id) {
        return entityManager.find(User.class, id);
    }

    public void save(User user) {
        entityManager.persist(user);
    }

    public void update(long id, User updateUser) {

        User user = entityManager.find(User.class, id);
        user.setAge(updateUser.getAge());
        user.setName(updateUser.getName());
        user.setEmail(updateUser.getEmail());
        entityManager.persist(user);
    }

    public void delete(long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
