package hello.controllers;

import hello.domain.Pupil;
import hello.domain.Role;
import hello.repos.PupilReposutory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
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
    public String userEdit(@PathVariable Pupil pupil, Model model){
        model.addAttribute("pupil", pupil);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }
    @PostMapping
    public String userSave(@RequestParam("UserId") Pupil pupil, @RequestParam Map<String, String> form, @RequestParam String name){
        pupil.setName(name);
        Set<String> roles = Arrays.stream(Role.values()).map(Role::name).collect(Collectors.toSet());
        pupil.getRoles().clear();
        for (String key:form.keySet()) {
            if (roles.contains(key)){
                pupil.getRoles().add(Role.valueOf(key));
            }
        }
        pupilReposutory.save(pupil);
        return "redirect:/pupils";
    }
    @RequestMapping("/error")
    public String error(){
        return "error";
    }
}
