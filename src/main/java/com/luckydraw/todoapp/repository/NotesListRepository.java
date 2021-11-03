package com.luckydraw.todoapp.repository;

import com.luckydraw.todoapp.model.NotesList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesListRepository extends JpaRepository<NotesList, Long> {
}
