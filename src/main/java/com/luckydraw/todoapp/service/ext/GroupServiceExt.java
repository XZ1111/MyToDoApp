package com.luckydraw.todoapp.service.ext;

import com.luckydraw.todoapp.model.Group;
import com.luckydraw.todoapp.repository.AbstractDao;
import com.luckydraw.todoapp.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GroupServiceExt extends AbstractService<Group> {

    public GroupServiceExt(AbstractDao<Group> abstractDao) {
        super(abstractDao);
        this.clazz = Group.class;
    }
}
