package com.luckydraw.todoapp.controller;


import com.luckydraw.todoapp.model.NotesList;
import com.luckydraw.todoapp.model.User;
import com.luckydraw.todoapp.service.ext.NotesListServiceExt;
import com.luckydraw.todoapp.service.ext.UserServiceExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    private UserServiceExt userServiceExt;

    private NotesListServiceExt notesListServiceExt;

    @Autowired
    public HomeController(UserServiceExt userServiceExt, NotesListServiceExt notesListServiceExt) {
        this.userServiceExt = userServiceExt;
        this.notesListServiceExt = notesListServiceExt;
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index (Model model){
        List<NotesList> notesList = notesListServiceExt.getAll();

        model.addAttribute("notesList", notesList);
        return "index";
    }

    @RequestMapping(value = "/notes-list/delete/{id}", method = RequestMethod.GET)
    public String deleteNotesList(@PathVariable("id") long id){
        NotesList notesList = notesListServiceExt.getById(id);

        if(notesList != null) notesListServiceExt.remove(notesList);
        else return null;//TODO implements error

        return "redirect:/index";
    }

    @RequestMapping(value = "/notes-list/getList", method = RequestMethod.GET)
    @ResponseBody
    public NotesList getList(Long id){
        return notesListServiceExt.getById(id);
    }

    @RequestMapping(value = "/notes-list/new", method = RequestMethod.POST)
    public String create(NotesList notesList){
        notesList.setDate(new Date());
        notesList.setUser(userServiceExt.getById(1L));
        notesListServiceExt.create(notesList);
        return "redirect:/index";
    }


}
