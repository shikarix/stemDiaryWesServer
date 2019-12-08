package hello.controllers;

import hello.domain.Pupil;
import hello.repos.PupilReposutory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "timetable")
public class TimetableController {
    @Autowired
    PupilReposutory pupilReposutory;

    @GetMapping(path = "/{pupil}")
    public String timetableList(Model model, @PathVariable Pupil pupil){
        
        return "timetable";
    }
}
