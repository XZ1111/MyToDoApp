package com.luckydraw.todoapp.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "text")
    @NotNull
    private String text;

    //TODO refactor date format
    @Column(name = "date")
    @NotNull
    private Date date;

    @Column(name = "complete")
    @NotNull
    private Boolean completed;

    @ManyToOne(optional = false)
    @JoinColumn(name = "group_id")
    private Group group;
}
