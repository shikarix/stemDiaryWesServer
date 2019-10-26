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
    int dollars = 100;
    @RequestMapping(value="/greeting", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @RequestMapping(value="/greeting", method=RequestMethod.POST)
    public String greetingSubmit(HashMap<String, Object> model, @RequestParam String login, @RequestParam String password) {
        Pupil pupil = new Pupil(login, password);
        pupilRepository.save(pupil);
        Iterable<Pupil> pupils = pupilRepository.findAll();
        System.out.println(pupils);
        model.put("pupils", pupils);
        model.put("dollars", dollars);
        List filterPupils = filter(login, model);
        for (Pupil pupilFiltered:pupils) {
            if (pupilFiltered.getPassword().equals(password)){
                model.put("pupils", pupilFiltered);
                return "profile";
            }
            else {
                return "";
            }
        }
        return "";
    }

    @GetMapping(value = "/profile")
    public String profile(Model model){
        return "profile";
    }

    @PostMapping(path = "/profile")
    public String add(Model model){
        Iterable<Pupil> pupils = pupilRepository.findAll();
        model.addAttribute("pupils", pupils);
        return "profile";
    }

    public List filter(@RequestParam String login, HashMap<String, Object> model){
        List pupils = pupilRepository.findByLogin(login);
        model.put("pupils", pupils);
        return pupils;
    }
}