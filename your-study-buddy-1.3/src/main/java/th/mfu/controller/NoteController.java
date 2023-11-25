package th.mfu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import th.mfu.domain.Note;
import th.mfu.repository.NoteRepository;

@Controller
public class NoteController {
    @Autowired
    NoteRepository noteRepo;

    // @GetMapping("/notes")
    // public String addNote(Model model) {
    // model.addAttribute("note", new Note());
    // return "notes";
    // }

    // @PostMapping("/save-notes")
    // public String saveNote(@ModelAttribute Note newnote, Model model) {
    // noteRepo.save(newnote);
    // Iterable<Note> addednotes = noteRepo.findAll();
    // model.addAttribute("notes", addednotes);
    // return "notes";
    // }

    @PostMapping("/save-notes")
    public String saveNote(@ModelAttribute Note newnote) {
        noteRepo.save(newnote);
        return "redirect:/notes";
    }

    @GetMapping("/add-notes")
    public String addNote(Model model) {
        model.addAttribute("note", new Note());
        return "add-notes";
    }

    @GetMapping("/notes")
    public String listNote(Model model) {
        model.addAttribute("notes", noteRepo.findAll());
        return "notes";
    }

}
