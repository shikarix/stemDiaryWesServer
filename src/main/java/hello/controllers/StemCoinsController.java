package hello.controllers;

import hello.domain.Accounts;
import hello.domain.LessonDef;
import hello.repos.LessonDefRepository;
import hello.repos.PupilReposutory;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Controller
public class StemCoinsController {
    @Autowired
    PupilReposutory pupilReposutory;

    @Autowired
    LessonDefRepository lessonDefRepository;

    @RequestMapping("/courseGet/{login}/{password}")
    public String course(Model model, @PathVariable String login, @PathVariable String password) {
        Accounts account = pupilReposutory.findByLoginAndPassword(login, password).isEmpty() ? null : pupilReposutory.findByLoginAndPassword(login, password).get(0);
        if (account != null) {
            JSONArray array = new JSONArray();
            for (int i = 0; i < lessonDefRepository.findByTeacherId(account.getId()).toArray().length; i++) {
                array.put(lessonDefRepository.findByTeacherId(account.getId()).get(i).getLessonName());
            }
            model.addAttribute("lessons", array.toString());
        }
        return "course";
    }

    @RequestMapping("/lessonGet/{login}/{password}/{course}")
    public String lesson(Model model, @PathVariable String login, @PathVariable String password, @PathVariable String course) {
        Accounts account = pupilReposutory.findByLoginAndPassword(login, password).isEmpty() ? null : pupilReposutory.findByLoginAndPassword(login, password).get(0);
        if (account != null) {
            LessonDef lessonDef = lessonDefRepository.findByLessonName(course).isEmpty() ? null : lessonDefRepository.findByLessonName(course).get(0);
            if (lessonDef != null) {
                ArrayList<GregorianCalendar> calendar = new ArrayList<>();
                calendar.add(lessonDef.getFirstTime());
                for (int i = 0; i < 10; i++) {
                    lessonDef.getFirstTime().add(Calendar.DAY_OF_MONTH, 7);
                    calendar.add(lessonDef.getFirstTime());
                }
                model.addAttribute("calendar", calendar);
            }
        }

        return "course";
    }


}
