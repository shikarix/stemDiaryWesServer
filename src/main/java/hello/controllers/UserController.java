package hello.controllers;

import hello.domain.Accounts;
import hello.repos.PupilReposutory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pupils")
public class UserController {
    @Autowired
    public PupilReposutory pupilReposutory;
    @GetMapping
    public String userList(Model model){
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        model.addAttribute("pupils", pupilReposutory.findAll());
        return "userList";
    }
    @GetMapping("{pupil}")
    public String userEdit(@PathVariable Accounts pupil, Model model){
        model.addAttribute("pupil", pupil);
        return "userEdit";
    }
    @PostMapping
    public String userSave(@RequestParam("UserId") Accounts pupil, @RequestParam boolean isAdmin,@RequestParam boolean isTeacher, @RequestParam String name, @RequestParam String surname){
        pupil.setName(name);
        pupil.setSurname(surname);

        pupilReposutory.save(pupil);
        return "redirect:/pupils";
    }
    @RequestMapping("/error")
    public String error(){
        return "error";
    }
}
