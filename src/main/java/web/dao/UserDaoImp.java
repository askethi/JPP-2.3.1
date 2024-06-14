package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
   @PersistenceContext(type= PersistenceContextType.TRANSACTION)
   private EntityManager em;

   @Override
   public void add(User user) {
      em.persist(user);
   }

   @Override
   public void deleteUserById(Long id) {
      User user = em.find(User.class, id);
      em.remove(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      return em.createQuery("select u from User u", User.class).getResultList();
   }

   @Override
   public User getUserById(Long id) {
      return em.find(User.class, id);
   }

   @Override
   public void updateUserById(User user, Long id) {
      em.merge(user);
   }


   @Override
   public int clean(){
      String hql = "delete from User";
      return em.createQuery(hql).executeUpdate();
   }

}
