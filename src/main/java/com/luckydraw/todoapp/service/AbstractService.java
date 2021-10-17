package com.luckydraw.todoapp.service;

import com.luckydraw.todoapp.repository.AbstractDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public abstract class AbstractService<T> {

    private AbstractDao<T> abstractDao;
    protected Class<T> clazz;

    @Autowired
    public AbstractService(AbstractDao<T> abstractDao) {
        this.abstractDao = abstractDao;
    }

    public T getById(Long id){
        return abstractDao.getById(id);
    }

    public T create(T t){
        return abstractDao.create(t);
    }

    public void remove(T t){
        abstractDao.remove(t);
    }

    public List<T> getAll(){
        return abstractDao.getAll();
    }
}
