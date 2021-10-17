package com.luckydraw.todoapp.repository.ext;

import com.luckydraw.todoapp.model.NotesList;
import com.luckydraw.todoapp.repository.AbstractDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class NotesListDaoExt extends AbstractDao<NotesList> {

    public NotesListDaoExt(EntityManager em) {
        super(em);
        this.clazz = NotesList.class;
    }
}
