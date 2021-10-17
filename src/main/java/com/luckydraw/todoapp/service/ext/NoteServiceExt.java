package com.luckydraw.todoapp.service.ext;

import com.luckydraw.todoapp.model.Note;
import com.luckydraw.todoapp.repository.AbstractDao;
import com.luckydraw.todoapp.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NoteServiceExt extends AbstractService<Note> {

    public NoteServiceExt(AbstractDao<Note> abstractDao) {
        super(abstractDao);
        this.clazz = Note.class;
    }
}
