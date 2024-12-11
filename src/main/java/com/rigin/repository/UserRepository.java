package com.rigin.repository;

import com.rigin.model.entity.Task;
import com.rigin.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.*;

@Slf4j
@AllArgsConstructor
public class UserRepository implements Repository<User, Long> {
    public static final String DOUBLE_DOT_EQUALS = "=:";
    private final SessionFactory sessionFactory;
    //NamedParameterJdbcTemplate

    //TODO condition
    @Override
    public Optional<User> findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            try {
                return (Optional.ofNullable(session.get(User.class, id)));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<User> getAll() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "from User ";
            Query<User> query = session.createQuery(hql, User.class);
            return query.getResultList();
        }

    }

    @Override
    public void save(User User) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(User);
            transaction.commit();
        }
    }

    @Override
    public void delete(User User) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(User);
            transaction.commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            User User = session.get(User.class, id);
            session.remove(User);
            transaction.commit();
        }
    }

    @Override
    public User update(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(user);
            transaction.commit();
        }
        return user;
    }

    public User updateById(Long id, User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            User user1 = session.get(User.class, id);
            session.merge(user);
            transaction.commit();
        }
        return user;
    }

    //TODO do hql query
    public Long updateById(Long id1, String nameOfFieldOfUser, String nameOfParameter) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            String hql = "update  com.rigin.model.entity.User u set u." + nameOfFieldOfUser + " " + DOUBLE_DOT_EQUALS + "name" + "  where u.id= :id1";
            Query query = session.createQuery(hql);
            query.setParameter("name", nameOfParameter);
            query.setParameter("id1", id1);
            long result = query.executeUpdate();
            transaction.commit();
            return result;
        }
    }

    public Optional<User> getUserByEmailAndPassword(String email, String password) {
        Optional<User> result = Optional.empty();
        try (Session session = sessionFactory.openSession()) {
            //Transaction transaction = session.beginTransaction();
            String hql = "from  User u  where u.email= :email1 and u.password= :password1";
            Query<User> query = session.createQuery(hql);
            query.setParameter("email1", email);
            query.setParameter("password1", password);
            result = Optional.ofNullable((User) query.uniqueResult());
        }


        return result;
    }



}
