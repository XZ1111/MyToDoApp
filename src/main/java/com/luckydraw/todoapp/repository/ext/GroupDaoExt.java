package com.luckydraw.todoapp.repository.ext;

import com.luckydraw.todoapp.model.Group;
import com.luckydraw.todoapp.repository.AbstractDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class GroupDaoExt extends AbstractDao<Group> {

    public GroupDaoExt(EntityManager em) {
        super(em);
        this.clazz = Group.class;
    }
}
