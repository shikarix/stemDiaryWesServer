package hello.controllers;

import hello.domain.Pupil;
import hello.repos.PupilReposutory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(path = "/profile")
    public String add(Model model) {
        Iterable<Pupil> pupils = pupilRepository.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("pupils", pupils);
        return "profile";
    }

    public List filter(@RequestParam String login, HashMap<String, Object> model) {
        List pupils = pupilRepository.findByLogin(login);
        model.put("pupils", pupils);
        return pupils;
    }

}