package com.luckydraw.todoapp.service.ext;

import com.luckydraw.todoapp.model.NotesList;
import com.luckydraw.todoapp.repository.AbstractDao;
import com.luckydraw.todoapp.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NotesListServiceExt extends AbstractService<NotesList> {

    public NotesListServiceExt(AbstractDao<NotesList> abstractDao) {
        super(abstractDao);
        this.clazz = NotesList.class;
    }
}
