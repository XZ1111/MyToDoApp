package com.luckydraw.todoapp.controller;


import com.luckydraw.todoapp.model.NotesList;
import com.luckydraw.todoapp.service.ext.NotesListServiceExt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {

    private NotesListServiceExt notesListServiceExt;

    public HomeController(NotesListServiceExt notesListServiceExt) {
        this.notesListServiceExt = notesListServiceExt;
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index (Model model){
        List<NotesList> notesList = notesListServiceExt.getAll();

        model.addAttribute("notesList", notesList);
        return "index";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteNotesList(@PathVariable("id") long id){
        NotesList notesList = notesListServiceExt.getById(id);

        if(notesList != null) notesListServiceExt.remove(notesList);
        else return null;//TODO implements error

        return "redirect:/index";
    }


}
