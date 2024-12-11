package com.rigin.repository;

import com.rigin.model.entity.Comment;
import com.rigin.model.entity.Comment;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
public class CommentRepository implements Repository<Comment,Long> {

    private final SessionFactory sessionFactory;

    @Override
    public Optional<Comment> findById(Long id) {
        try(Session session=sessionFactory.openSession()){
            return Optional.ofNullable(session.get(Comment.class,id));
        }
    }

    @Override
    public List<Comment> getAll() {
        try (Session session = sessionFactory.openSession()) {
            String hql="select o from Comment o join fetch o.Comment";
            Query<Comment> query=session.createQuery(hql, Comment.class);
            List<Comment> list=query.getResultList();
            return list;
        }

    }

    @Override
    public void save(Comment Comment) {
        try(Session session =sessionFactory.openSession()){
            Transaction transaction=session.beginTransaction();
            session.merge(Comment);
            transaction.commit();
        }
    }

    @Override
    public void delete(Comment Comment) {
        try(Session session =sessionFactory.openSession()){
            Transaction transaction=session.beginTransaction();
            session.remove(Comment);
            transaction.commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        try(Session session =sessionFactory.openSession()){
            Transaction transaction=session.beginTransaction();
            Comment Comment=session.get(Comment.class,id);
            session.remove(Comment);
            transaction.commit();
        }
    }

    @Override
    public Comment update(Comment comment) {
        try(Session session =sessionFactory.openSession()){
            Transaction transaction=session.beginTransaction();
            session.merge(comment);
            transaction.commit();
        }
        return comment;
    }
}
