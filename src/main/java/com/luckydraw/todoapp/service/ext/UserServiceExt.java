package com.luckydraw.todoapp.service.ext;

import com.luckydraw.todoapp.model.User;
import com.luckydraw.todoapp.repository.AbstractDao;
import com.luckydraw.todoapp.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceExt extends AbstractService<User> {

    public UserServiceExt(AbstractDao<User> abstractDao) {
        super(abstractDao);
        this.clazz = User.class;
    }
}
