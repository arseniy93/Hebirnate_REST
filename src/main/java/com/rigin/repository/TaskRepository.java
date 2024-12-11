package com.rigin.repository;

import com.rigin.model.entity.Task;
import com.rigin.model.entity.Task;
import com.rigin.model.entity.User;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
public class TaskRepository implements Repository<Task, Long> {
    private final SessionFactory sessionFactory;

    public void setTaskToUser(Long idOfTask, Long idOfUser){
//        try (Session session = sessionFactory.openSession()) {
//            //Transaction transaction = session.beginTransaction();
//            String hql = "from  User u  where u.email= :email1 and u.password= :password1";
//            Query<User> query = session.createQuery(hql);
//            query.setParameter("email1", email);
//            query.setParameter("password1", password);
//            result=Optional.ofNullable( (User) query.uniqueResult());
//        }
    }

    @Override
    public Optional<Task> findById(Long id) {
        try(Session session=sessionFactory.openSession()){
            return Optional.ofNullable(session.get(Task.class,id));
        }
    }

    @Override
    public List<Task> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Task", Task.class).list();
        }

    }

    @Override
    public void save(Task Task) {
        try(Session session =sessionFactory.openSession()){
            Transaction transaction=session.beginTransaction();
            session.persist(Task);
            transaction.commit();
        }
    }

    @Override
    public void delete(Task Task) {
        try(Session session =sessionFactory.openSession()){
            Transaction transaction=session.beginTransaction();
            session.remove(Task);
            transaction.commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        try(Session session =sessionFactory.openSession()){
            Transaction transaction=session.beginTransaction();
            Task Task=session.get(Task.class,id);
            session.remove(Task);
            transaction.commit();
        }
    }

    @Override
    public Task update(Task Task) {
        try(Session session =sessionFactory.openSession()){
            Transaction transaction=session.beginTransaction();
            session.merge(Task);
            transaction.commit();
        }
        return Task;
    }

    public Set<Task> getUserTasksByUserId(Long id) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT DISTINCT t FROM User u JOIN u.tasks t WHERE u.id = :id";
            Query<Task> query = session.createQuery(hql, Task.class);
            query.setParameter("id", id);
            return new HashSet<>(query.getResultList());
        }
    }
}
