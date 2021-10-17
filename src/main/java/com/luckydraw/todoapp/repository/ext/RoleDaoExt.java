package com.luckydraw.todoapp.repository.ext;

import com.luckydraw.todoapp.model.Role;
import com.luckydraw.todoapp.repository.AbstractDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class RoleDaoExt extends AbstractDao<Role> {

    public RoleDaoExt(EntityManager em) {
        super(em);
        this.clazz = Role.class;
    }
}
