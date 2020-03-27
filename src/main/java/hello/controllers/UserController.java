package hello.controllers;

import hello.domain.Accounts;
import hello.repos.PupilReposutory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    public PupilReposutory pupilReposutory;

    @GetMapping("/error")
    public String error(){
        return "error";
    }
    @PostMapping("/error")
    public String errorOnPost(){
        return "error";
    }

    @GetMapping("/adminPanel")
    public String adminPanel(Model model){
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        return "adminPanel";
    }

    @GetMapping("/pupils")
    public String userList(Model model){
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        model.addAttribute("pupils", pupilReposutory.findAll());
        return "userList";
    }
    @GetMapping("/pupils/{pupil}")
    public String userEdit(@PathVariable int pupil, Model model){
        Accounts p = pupilReposutory.findAll().size() == pupil ? new Accounts() : pupilReposutory.findAllById(pupil).get(0);
        model.addAttribute("p", p);
        System.out.println(p.toString());
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        return p.getName() == null ? "redirect:/create" : "userEdit";
    }
    @PostMapping("/pupils")
    public String userSave(@RequestParam("UserId") Accounts pupil, @RequestParam(required = false, defaultValue = "false") boolean isAdmin, @RequestParam(required = false, defaultValue = "false") boolean isTeacher, @RequestParam String name, @RequestParam String surname, Model model){
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        pupil.setName(name);
        pupil.setSurname(surname);
        pupil.setTeacher(isTeacher);
        pupil.setAdmin(isAdmin);
        pupilReposutory.save(pupil);
        return "redirect:/pupils";
    }

    @GetMapping("/create")
    public String createUser(Model model){
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        return "createUser";
    }

    @PostMapping("/create")
    public String saveNewUser(@RequestParam String login, @RequestParam String password, @RequestParam String name, @RequestParam String surname, @RequestParam String url, @RequestParam(required = false, defaultValue = "false") boolean isAdmin, @RequestParam(required = false, defaultValue = "false") boolean isTeacher){
        Accounts pupil = new Accounts(pupilReposutory.findAll().size(), login, password, name, surname, isTeacher, isAdmin, url);

        pupilReposutory.save(pupil);
        return "redirect:/pupils";
    }

}
