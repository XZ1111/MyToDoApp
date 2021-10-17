package com.luckydraw.todoapp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public abstract class AbstractDao<T> {

    private final EntityManager em;
    protected Class<T> clazz;

    @Autowired
    public AbstractDao(EntityManager em) {
        this.em = em;
    }

    public T getById(Long id){
        return em.find(clazz, id);
    }

    public T create(T t){
        em.persist(t);
        return t;
    }

    public void remove(T t){
        em.remove(t);
    }

    public List<T> getAll(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(clazz);
        Root<T> root = cq.from(clazz);
        CriteriaQuery<T> all = cq.select(root);

        TypedQuery<T> allQuery = em.createQuery(all);

        return allQuery.getResultList();
    }
}
