package com.luckydraw.todoapp.service.ext;

import com.luckydraw.todoapp.model.Role;
import com.luckydraw.todoapp.repository.AbstractDao;
import com.luckydraw.todoapp.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceExt extends AbstractService<Role> {

    public RoleServiceExt(AbstractDao<Role> abstractDao) {
        super(abstractDao);
        this.clazz = Role.class;
    }
}
