package hello;

import hello.domain.Pupil;
import hello.repos.PupilReposutory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private PupilReposutory pupilRepository;

    @GetMapping(value = "/")
    public String greetingForm(Model model) {
        return "profile";
    }

    @RequestMapping(path = "/profile")
    public String add(Model model) {
        Iterable<Pupil> pupils = pupilRepository.findAll();
        model.addAttribute("pupils", pupils);
        return "profile";
    }

    public List filter(@RequestParam String login, HashMap<String, Object> model) {
        List pupils = pupilRepository.findByLogin(login);
        model.put("pupils", pupils);
        return pupils;
    }
}