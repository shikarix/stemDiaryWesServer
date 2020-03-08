package hello.controllers;

import hello.domain.Accounts;
import hello.repos.PupilReposutory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Controller
public class TimetableController {
    @Autowired
    PupilReposutory pupilReposutory;

    @RequestMapping(path = "/timetable")
    public String timetableList(Model model){
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isAdmin());
        Accounts pupil = pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0);
        System.out.println(pupil);
        ArrayList<String> dates = new ArrayList<>();
        GregorianCalendar calendar = pupil.getFirstDate();
        dates.add(calendar.get(Calendar.DAY_OF_MONTH) + " " +
                (calendar.get(Calendar.MONTH) == GregorianCalendar.JANUARY ? "января" :
                 calendar.get(Calendar.MONTH) == GregorianCalendar.FEBRUARY ? "февраля" :
                 calendar.get(Calendar.MONTH) == GregorianCalendar.MARCH ? "марта" :
                 calendar.get(Calendar.MONTH) == GregorianCalendar.APRIL ? "апреля" :
                 calendar.get(Calendar.MONTH) == GregorianCalendar.MAY ? "мая" :
                 calendar.get(Calendar.MONTH) == GregorianCalendar.JUNE ? "июня" :
                 calendar.get(Calendar.MONTH) == GregorianCalendar.JULY ? "июля" :
                 calendar.get(Calendar.MONTH) == GregorianCalendar.AUGUST ? "августа" :
                 calendar.get(Calendar.MONTH) == GregorianCalendar.SEPTEMBER ? "сентября" :
                 calendar.get(Calendar.MONTH) == GregorianCalendar.OCTOBER ? "октября" :
                 calendar.get(Calendar.MONTH) == GregorianCalendar.NOVEMBER ? "ноября" :
                 calendar.get(Calendar.MONTH) == GregorianCalendar.DECEMBER ? "декабря" : "Вы дурачок"));
        for (int i = 0; i < 10; i++) {
            calendar.add(Calendar.DAY_OF_MONTH,7);
            dates.add(calendar.get(Calendar.DAY_OF_MONTH) + " " +
                    (calendar.get(Calendar.MONTH) == GregorianCalendar.JANUARY ? "января" :
                     calendar.get(Calendar.MONTH) == GregorianCalendar.FEBRUARY ? "февраля" :
                     calendar.get(Calendar.MONTH) == GregorianCalendar.MARCH ? "марта" :
                     calendar.get(Calendar.MONTH) == GregorianCalendar.APRIL ? "апреля" :
                     calendar.get(Calendar.MONTH) == GregorianCalendar.MAY ? "мая" :
                     calendar.get(Calendar.MONTH) == GregorianCalendar.JUNE ? "июня" :
                     calendar.get(Calendar.MONTH) == GregorianCalendar.JULY ? "июля" :
                     calendar.get(Calendar.MONTH) == GregorianCalendar.AUGUST ? "августа" :
                     calendar.get(Calendar.MONTH) == GregorianCalendar.SEPTEMBER ? "сентября" :
                     calendar.get(Calendar.MONTH) == GregorianCalendar.OCTOBER ? "октября" :
                     calendar.get(Calendar.MONTH) == GregorianCalendar.NOVEMBER ? "ноября" :
                     calendar.get(Calendar.MONTH) == GregorianCalendar.DECEMBER ? "декабря" : "Вы дурачок"));
            System.out.println(calendar.get(Calendar.DAY_OF_MONTH) + " " + calendar.get(Calendar.MONTH));
        }
        model.addAttribute("dates", dates);
        return "timetable";
    }
}
