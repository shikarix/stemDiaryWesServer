package hello.controllers;

import hello.domain.Accounts;
import hello.repos.PupilReposutory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Controller
@RequestMapping(path = "timetableAndroid")
public class TimetableForAndroidController {
    @Autowired
    PupilReposutory pupilReposutory;

    @GetMapping(path = "/{pupil}")
    public String timetableList(Model model, @PathVariable Accounts pupil){
        String[] a = {"не работает", "не работает"};
        model.addAttribute("dates", a);
        return "timetableAndroid";
    }
}