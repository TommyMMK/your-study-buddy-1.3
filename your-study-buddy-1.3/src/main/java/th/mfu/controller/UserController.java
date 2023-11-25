package th.mfu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import th.mfu.domain.User;
import th.mfu.repository.UserRepository;

@Controller
public class UserController {
    @Autowired
    UserRepository userrepo;

    public UserController(UserRepository userrepo) {
        this.userrepo = userrepo;
    }

    @GetMapping("/home")
    public String HomePage(){
        return "home";
    }

    @GetMapping("/help")
    public String HelpPage(){
        return "Help";
    }

    // to create buyer account
    @GetMapping("/signup")
    public String SingupForm(Model model) {
        model.addAttribute("user", new User());
        return "signUp";
    }

    // to save buyer account
    @PostMapping("/save-user")
    public String saveUser(@ModelAttribute User user, Model model) {
        userrepo.save(user);
        Iterable<User> userlist = userrepo.findAll();
        model.addAttribute("user", userlist);
        return "home";
    }

    // to show buyer login form
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "Login";
    }

    // to login for buyer
    @PostMapping("/login")
    public String userLogin(@ModelAttribute User user, Model model) {
        if (userrepo.existsByEmail(user.getEmail()) == true) {
            User existUser = userrepo.findByEmail(user.getEmail());
            if (user.getPassword().equals(existUser.getPassword())) {
                return "Dashboard";
            } else {
                return "Login";
            }
        } else {
            return "Login";
        }
    }
}
