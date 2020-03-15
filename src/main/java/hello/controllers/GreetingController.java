package hello.controllers;

import hello.domain.Accounts;
import hello.repos.PupilReposutory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.util.ArrayList;

@Controller
public class GreetingController {
    @Autowired
    private PupilReposutory pupilRepository;
    @Autowired
    private DataSource dataSource;

    @GetMapping(value = "/")
    public String greetingForm(Model model) {
        return add(model);
    }

    @PostMapping(path = "/profile")
    public String editMe(@RequestParam String oldPassword, @RequestParam String newPassword, @RequestParam String againPassword, Model model) {
        Iterable<Accounts> pupils = pupilRepository.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        ArrayList<Accounts> pupil = new ArrayList<>();
        pupils.forEach(pupil::add);
        Accounts need = pupil.get(0);
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
        model.addAttribute("is", pupilRepository.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        Iterable<Accounts> pupils = pupilRepository.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("pupils", pupils);
        ArrayList<Accounts> pupil = new ArrayList<>();
        pupils.forEach(pupil::add);
        pupilRepository.save(pupil.get(0));
        if (model.asMap().get("warn") == null || model.asMap().get("warn").equals("")) model.addAttribute("warn", "");
        return "editMe";
    }
}