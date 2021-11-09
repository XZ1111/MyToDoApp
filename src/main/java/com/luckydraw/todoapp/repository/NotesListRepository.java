package com.luckydraw.todoapp.repository;

import com.luckydraw.todoapp.model.NotesList;
import com.luckydraw.todoapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NotesListRepository extends JpaRepository<NotesList, Long> {

    List<NotesList> findAllByUser(User user);
}
