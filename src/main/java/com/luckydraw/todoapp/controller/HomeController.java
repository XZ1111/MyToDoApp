package com.luckydraw.todoapp.controller;


import com.luckydraw.todoapp.model.NotesList;
import com.luckydraw.todoapp.model.User;
import com.luckydraw.todoapp.repository.NotesListRepository;
import com.luckydraw.todoapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

    private UserRepository userRepository;

    private NotesListRepository notesListRepository;

    @Autowired
    public HomeController(UserRepository userRepository, NotesListRepository notesListRepository) {
        this.userRepository = userRepository;
        this.notesListRepository = notesListRepository;
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index (Model model, Principal principal){
        List<NotesList> notesList = notesListRepository.findAllByUser(getCurrentUser(principal));

        model.addAttribute("notesList", notesList);
        return "index";
    }

    @RequestMapping(value = "/notes-list/delete/{id}", method = RequestMethod.GET)
    public String deleteNotesList(@PathVariable("id") long id){
        NotesList notesList = notesListRepository.getById(id);

        if(notesList != null) notesListRepository.delete(notesList);
        else return null;//TODO implements error

        return "redirect:/index";
    }

    @RequestMapping(value = "/notes-list/getList", method = RequestMethod.GET)
    @ResponseBody
    public NotesList getList(Long id){
        return notesListRepository.getById(id);
    }

    @RequestMapping(value = "/notes-list/new", method = RequestMethod.POST)
    public String create(NotesList notesList, Principal principal){
        notesList.setDate(new Date());
        notesList.setUser(userRepository.getById(getCurrentUser(principal).getId()));
        notesListRepository.save(notesList);
        return "redirect:/index";
    }

    public User getCurrentUser(Principal principal){
        return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }


}
