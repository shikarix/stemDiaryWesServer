package hello.controllers;

import hello.domain.Pupil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "timetable")
public class TimetableController {
    @GetMapping
    public String timetableList(Model model, Pupil pupil){
        return "timetable";
    }
}
