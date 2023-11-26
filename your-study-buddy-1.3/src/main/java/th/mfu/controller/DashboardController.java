package th.mfu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    
    @GetMapping("/dashboard")
    public String ShowDashBoard(){
        return "Dashboard";
    }

    @GetMapping("/studyroom")
    public String ShowStudyRoom(){
        return "StudyRoomMain";
    }

    @GetMapping("/flashcard")
    public String ShowFlashCard(){
        return "flashcardmain";
    }




}
