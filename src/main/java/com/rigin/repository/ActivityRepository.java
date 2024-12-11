package com.rigin.repository;

import com.rigin.model.entity.Activity;
import com.rigin.model.entity.Activity;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@AllArgsConstructor
public class ActivityRepository implements Repository<Activity, Long> {
    private final SessionFactory sessionFactory;

    @Override
    public Optional<Activity> findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(Activity.class, id));
        }
    }

    @Override
    public List<Activity> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Activity", Activity.class).list();
        }

    }

    @Override
    public void save(Activity Activity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(Activity);
            transaction.commit();
        }
    }

    @Override
    public void delete(Activity Activity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(Activity);
            transaction.commit();
        }
    }


    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Activity Activity = session.get(Activity.class, id);
            session.remove(Activity);
            transaction.commit();
        }
    }

    @Override
    public Activity update(Activity activity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(activity);
            transaction.commit();
        }
        return activity;
    }
}
