package hello.controllers;

import hello.domain.Pupil;
import hello.repos.PupilReposutory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.expression.Lists;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Controller
public class GreetingController {
    boolean was = false;
    @Autowired
    private PupilReposutory pupilRepository;
    @Autowired
    private DataSource dataSource;

    @GetMapping(value = "/")
    public String greetingForm(Model model) {
        return add(model);
    }

    @PostMapping(path = "/profile")
    public String editMe(@RequestParam String nickname, @RequestParam String surname, @RequestParam String oldPassword, @RequestParam String newPassword, @RequestParam String againPassword, Model model) {
        Iterable<Pupil> pupils = pupilRepository.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        ArrayList<Pupil> pupil = new ArrayList<>();
        pupils.forEach(pupil::add);
        if (!nickname.equals(""))
            pupil.get(0).setName(nickname);
        else {
            model.addAttribute("warn", "Имя не может быть пустым!");
            return add(model);
        }
        if (!surname.equals(""))
            pupil.get(0).setSurname(surname);
        else {
            model.addAttribute("warn", "Фамилия не может быть пустой!");
            return add(model);
        }
        Pupil need = pupil.get(0);
        if (oldPassword != null)
            if (!oldPassword.equals(" ") && !oldPassword.equals("")) {
                if (oldPassword.equals(need.getPassword())) {
                    if (newPassword != null)
                        if (!newPassword.equals("")) {
                            if (againPassword != null)
                                if (newPassword.equals(againPassword)) {
                                    need.setPassword(againPassword);
                                    model.addAttribute("warn", "Вы изменили пароль!");
                                    return add(model);
                                } else {
                                    model.addAttribute("warn", "Новые пароли не совпадают!");
                                    return add(model);
                                }
                        } else {
                            model.addAttribute("warn", "Если хотите изменить пароль, то введите новый пароль!");
                            return add(model);
                        }
                } else {
                    model.addAttribute("warn", "Введите свой старый пароль!");
                    return add(model);
                }
            }
        pupilRepository.save(pupil.get(0));
        return add(model);
    }

    @GetMapping(path = "/profile")
    public String profile(Model model) {
        return add(model);
    }

    @RequestMapping(path = "/editMe")
    public String add(Model model) {
        Iterable<Pupil> pupils = pupilRepository.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("pupils", pupils);
        ArrayList<Pupil> pupil = new ArrayList<>();
        pupils.forEach(pupil::add);
        model.addAttribute("was", pupil.get(0).isActive());
        pupil.get(0).setActive(true);
        pupilRepository.save(pupil.get(0));
        if (model.asMap().get("warn") == null || model.asMap().get("warn").equals(""))model.addAttribute("warn", "");
        return "editMe";
    }
}