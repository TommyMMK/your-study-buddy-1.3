package th.mfu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import th.mfu.domain.FlashCard;
import th.mfu.repository.FlashCardRepository;

@Controller
public class FlashCareController {
    
    @Autowired
    FlashCardRepository flashcardRepo;

    public FlashCareController(FlashCardRepository flashcardRepo) {
        this.flashcardRepo = flashcardRepo;
    }

     @GetMapping("/flashcards")
    public String listFlashCard(Model model) {
        model.addAttribute("flashcards", flashcardRepo.findAll());
        return "flashcardmain";
    }

    @GetMapping("/add-flashcard")
    public String addFlashCardForm(Model model) {
        model.addAttribute("newflashcard", new FlashCard());
        return "CreateFlashCard";
    }

    @PostMapping("/flashcards")
    public String saveFlashCard(@ModelAttribute FlashCard newflashcard) {
        flashcardRepo.save(newflashcard);
        return "redirect:/flashcards";
    }

}
