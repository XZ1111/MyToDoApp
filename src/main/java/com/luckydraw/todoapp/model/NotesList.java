package com.luckydraw.todoapp.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "notes_list")
public class NotesList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    //TODO refactor date format
    @Column(name = "date")
    @NotNull
    private Date date;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "notesList", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Group> groups;

}
