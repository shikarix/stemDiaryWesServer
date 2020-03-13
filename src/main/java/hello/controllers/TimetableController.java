package hello.controllers;

import hello.domain.Accounts;
import hello.domain.Lesson;
import hello.domain.ModelDomain.LessonTimes;
import hello.repos.LessonDefRepository;
import hello.repos.LessonRepository;
import hello.repos.PupilReposutory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Controller
public class TimetableController {
    @Autowired
    PupilReposutory pupilReposutory;

    @Autowired
    LessonRepository lessonRepository;

    @Autowired
    LessonDefRepository lessonDefRepository;

    @RequestMapping(path = "/timetable")
    public String timetableList(Model model) {
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        Accounts pupil = pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0);

        ArrayList<Lesson> lessons = lessonRepository.findByPupilId(pupil.getId());
        ArrayList<LessonTimes> modelLessons = new ArrayList<>();
        for (Lesson l : lessons) {
            LessonTimes lesson = new LessonTimes();
            lesson.id = l.getLessonId();
            lesson.urlToLessonLogo = lessonDefRepository.findByLessonId(l.getLessonId()).get(0).getUrlToLessonLogo();
            lesson.name = lessonDefRepository.findByLessonId(l.getLessonId()).get(0).getLessonName();
            lesson.time = lessonDefRepository.findByLessonId(l.getLessonId()).get(0).getFirstTime().get(Calendar.HOUR_OF_DAY) + ":" + (lessonDefRepository.findByLessonId(l.getLessonId()).get(0).getFirstTime().get(Calendar.MINUTE) == 0 ? "00" : lessonDefRepository.findByLessonId(l.getLessonId()).get(0).getFirstTime().get(Calendar.MINUTE));
            GregorianCalendar calendar = lessonDefRepository.findByLessonId(l.getLessonId()).get(0).getFirstTime();
            String hours = calendar.get(Calendar.HOUR_OF_DAY) > 9 ? calendar.get(Calendar.HOUR_OF_DAY) + "" : "0" + calendar.get(Calendar.HOUR_OF_DAY);
            String minutes = calendar.get(Calendar.MINUTE) > 9 ? calendar.get(Calendar.MINUTE) + "" : "0" + calendar.get(Calendar.MINUTE);
            String time = hours + ":" + minutes;
            String date = calendar.get(Calendar.DAY_OF_MONTH) + " " + convertMonth(calendar.get(Calendar.MONTH)) + " " + calendar.get(Calendar.YEAR) + " года";
            lesson.date1 = time + "<br/>" + date;
            lessonDefRepository.findByLessonId(l.getLessonId()).get(0).getFirstTime().add(Calendar.DAY_OF_MONTH, 7);
            modelLessons.add(lesson);
        }
        model.addAttribute("dates", modelLessons);
        return "timetable";
    }

    @RequestMapping("/timetable/{id}")
    public String more(Model model, @PathVariable int id) {
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());

        GregorianCalendar calendar = lessonDefRepository.findByLessonId(id).get(0).getFirstTime();

        model.addAttribute("name", lessonDefRepository.findByLessonId(id).get(0).getLessonName());
        model.addAttribute("date", calendar.get(Calendar.DAY_OF_MONTH) + " " + convertMonth(calendar.get(Calendar.MONTH)) + " " + calendar.get(Calendar.YEAR) + " года");

        String hours = calendar.get(Calendar.HOUR_OF_DAY) > 9 ? calendar.get(Calendar.HOUR_OF_DAY) + "" : "0" + calendar.get(Calendar.HOUR_OF_DAY);
        String minutes = calendar.get(Calendar.MINUTE) > 9 ? calendar.get(Calendar.MINUTE) + "" : "0" + calendar.get(Calendar.MINUTE);
        model.addAttribute("time", (hours + ":" + minutes));

        ArrayList<String> dates = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, 7);
            dates.add(calendar.get(Calendar.DAY_OF_MONTH) + " " + convertMonth(calendar.get(Calendar.MONTH)) + " " + calendar.get(Calendar.YEAR) + " года");
        }
        model.addAttribute("dates", dates);

        return "moreAboutLesson";
    }

    public static String convertMonth(int id) {
        return id == GregorianCalendar.JANUARY ? "января" :
                id == GregorianCalendar.FEBRUARY ? "февраля" :
                id == GregorianCalendar.MARCH ? "марта" :
                id == GregorianCalendar.APRIL ? "апреля" :
                id == GregorianCalendar.MAY ? "мая" :
                id == GregorianCalendar.JUNE ? "июня" :
                id == GregorianCalendar.JULY ? "июля" :
                id == GregorianCalendar.AUGUST ? "августа" :
                id == GregorianCalendar.SEPTEMBER ? "сентября" :
                id == GregorianCalendar.OCTOBER ? "октября" :
                id == GregorianCalendar.NOVEMBER ? " ноября" : "декабря";
    }


}
