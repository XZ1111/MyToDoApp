package com.luckydraw.todoapp.repository;

import com.luckydraw.todoapp.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    @Query("select g from Group g where g.id=:id")
    List<Group> findAllByNotesListId(@Param("id")Long id);
}
