package th.mfu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import th.mfu.domain.StudyRoom;
import th.mfu.repository.StudyRoomRepository;



@Controller
public class StudyRoomController {


    @Autowired
    StudyRoomRepository studyroomRepo;

     public StudyRoomController(StudyRoomRepository studyroomRepo) {
        this.studyroomRepo = studyroomRepo;
    }

    

    @GetMapping("/studyrooms")
    public String listStudyRoom(Model model) {
        model.addAttribute("flashcards", studyroomRepo.findAll());
        return "StudyRoomMain";
    }

    @GetMapping("/add-studyroom")
    public String addStudyRoomForm(Model model) {
        model.addAttribute("newstudyroom", new StudyRoom());
        return "createStudyRoom";
    }

    @PostMapping("/studyrooms")
    public String saveStudyRoom(@ModelAttribute StudyRoom newstudyroom) {
        studyroomRepo.save(newstudyroom);
        return "redirect:/studyrooms";
    }

    @GetMapping("/edit-studyroom/{id}")
    public String editStudyRoomForm(@PathVariable Long id, Model model) {
        StudyRoom studyroom = studyroomRepo.findById(id).orElse(null);
        model.addAttribute("editstudyroom", studyroom);
        return "EditStudyRoom";
    }

    // Update flashcard
    @PostMapping("/update-studyroom/{id}")
    public String updateStudyRoom(@PathVariable Long id, @ModelAttribute StudyRoom updatedStudyRoom) {
        StudyRoom studyroom = studyroomRepo.findById(id).orElse(null);
        if (studyroom != null) {
            studyroom.setName(updatedStudyRoom.getName());
            studyroomRepo.save(studyroom);
        }
        return "redirect:/studyrooms";
    }

    // Delete flashcard
    @GetMapping("/delete-studyroom/{id}")
    public String deleteStudyRoom(@PathVariable Long id) {
        studyroomRepo.deleteById(id);
        return "redirect:/studyrooms";
    }
}
