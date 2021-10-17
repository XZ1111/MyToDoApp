package com.luckydraw.todoapp.repository.ext;

import com.luckydraw.todoapp.model.User;
import com.luckydraw.todoapp.repository.AbstractDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class UserDaoExt extends AbstractDao<User> {

    public UserDaoExt(EntityManager em) {
        super(em);
        this.clazz = User.class;
    }
}
