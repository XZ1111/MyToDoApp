package com.luckydraw.todoapp.controller;


import com.luckydraw.todoapp.model.NotesList;
import com.luckydraw.todoapp.service.ext.NotesListServiceExt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HomeController {

    private NotesListServiceExt notesListServiceExt;

    public HomeController(NotesListServiceExt notesListServiceExt) {
        this.notesListServiceExt = notesListServiceExt;
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String getAll(Model model){
        List<NotesList> notesList = notesListServiceExt.getAll();

        model.addAttribute("notesList", notesList);
        return "/index";
    }
}
