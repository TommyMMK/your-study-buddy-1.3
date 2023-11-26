package th.mfu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import th.mfu.domain.FlashCard;
import th.mfu.repository.FlashCardRepository;

@Controller
public class FlashCaredController {
    
    @Autowired
    FlashCardRepository flashcardRepo;

    public FlashCaredController(FlashCardRepository flashcardRepo) {
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

    @GetMapping("/edit-flashcard/{id}")
    public String editFlashCardForm(@PathVariable Long id, Model model) {
        FlashCard flashcard = flashcardRepo.findById(id).orElse(null);
        model.addAttribute("editflashcard", flashcard);
        return "EditFlashCard";
    }

    // Update flashcard
    @PostMapping("/update-flashcard/{id}")
    public String updateFlashCard(@PathVariable Long id, @ModelAttribute FlashCard updatedFlashCard) {
        FlashCard flashcard = flashcardRepo.findById(id).orElse(null);
        if (flashcard != null) {
            flashcard.setName(updatedFlashCard.getName());
            flashcard.setFrontLabel(updatedFlashCard.getFrontLabel());
            flashcard.setBackLabel(updatedFlashCard.getBackLabel());
            flashcardRepo.save(flashcard);
        }
        return "redirect:/flashcards";
    }

    // Delete flashcard
    @GetMapping("/delete-flashcard/{id}")
    public String deleteFlashCard(@PathVariable Long id) {
        flashcardRepo.deleteById(id);
        return "redirect:/flashcards";
    }

}
