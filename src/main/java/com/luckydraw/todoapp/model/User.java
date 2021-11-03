package com.luckydraw.todoapp.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull
    private String username;

    @Column(name = "password")
    @NotNull
    private String password;

    @Transient
    private String passwordConfirm;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<NotesList> notesList;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;
}
