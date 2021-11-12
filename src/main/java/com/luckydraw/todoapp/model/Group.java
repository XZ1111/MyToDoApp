package com.luckydraw.todoapp.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "notes_group")
public class Group {

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
    @JoinColumn(name = "note_list_id")
    private NotesList notesList;

    @OneToMany(mappedBy = "group", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Note> notes;
}
