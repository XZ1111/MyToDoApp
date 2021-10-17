package com.luckydraw.todoapp.repository.ext;

import com.luckydraw.todoapp.model.Note;
import com.luckydraw.todoapp.repository.AbstractDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class NoteDaoExt extends AbstractDao<Note> {

    public NoteDaoExt(EntityManager em) {
        super(em);
        this.clazz = Note.class;
    }
}
