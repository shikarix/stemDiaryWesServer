package hello.controllers;

import hello.domain.Accounts;
import hello.domain.Role;
import hello.repos.PupilReposutory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/pupils")
@PreAuthorize("hasAuthority('MODERATOR')")
public class UserController {
    @Autowired
    public PupilReposutory pupilReposutory;
    @GetMapping
    public String userList(Model model){
        model.addAttribute("pupils", pupilReposutory.findAll());
        return "userList";
    }
    @GetMapping("{pupil}")
    public String userEdit(@PathVariable Accounts pupil, Model model){
        model.addAttribute("pupil", pupil);
        model.addAttribute("roles", Role.values());
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
