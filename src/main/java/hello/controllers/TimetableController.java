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
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

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
            lesson.name = lessonDefRepository.findByLessonId(l.getLessonId()).get(0).getLessonName();
            lesson.time = lessonDefRepository.findByLessonId(l.getLessonId()).get(0).getFirstTime().get(Calendar.HOUR_OF_DAY) + ":" + (lessonDefRepository.findByLessonId(l.getLessonId()).get(0).getFirstTime().get(Calendar.MINUTE) == 0 ? "00" : lessonDefRepository.findByLessonId(l.getLessonId()).get(0).getFirstTime().get(Calendar.MINUTE));
            lesson.date1 = lessonDefRepository.findByLessonId(l.getLessonId()).get(0).getFirstTime().get(Calendar.DAY_OF_MONTH) + "." + (lessonDefRepository.findByLessonId(l.getLessonId()).get(0).getFirstTime().get(Calendar.MONTH) + 1) + "." + lessonDefRepository.findByLessonId(l.getLessonId()).get(0).getFirstTime().get(Calendar.YEAR);
            lessonDefRepository.findByLessonId(l.getLessonId()).get(0).getFirstTime().add(Calendar.DAY_OF_MONTH, 7);
            lesson.date2 = lessonDefRepository.findByLessonId(l.getLessonId()).get(0).getFirstTime().get(Calendar.DAY_OF_MONTH) + "." + (lessonDefRepository.findByLessonId(l.getLessonId()).get(0).getFirstTime().get(Calendar.MONTH) + 1) + "." + lessonDefRepository.findByLessonId(l.getLessonId()).get(0).getFirstTime().get(Calendar.YEAR);
            lessonDefRepository.findByLessonId(l.getLessonId()).get(0).getFirstTime().add(Calendar.DAY_OF_MONTH, 7);
            lesson.date3 = lessonDefRepository.findByLessonId(l.getLessonId()).get(0).getFirstTime().get(Calendar.DAY_OF_MONTH) + "." + (lessonDefRepository.findByLessonId(l.getLessonId()).get(0).getFirstTime().get(Calendar.MONTH) + 1) + "." + lessonDefRepository.findByLessonId(l.getLessonId()).get(0).getFirstTime().get(Calendar.YEAR);
            lessonDefRepository.findByLessonId(l.getLessonId()).get(0).getFirstTime().add(Calendar.DAY_OF_MONTH, 7);
            lesson.date4 = lessonDefRepository.findByLessonId(l.getLessonId()).get(0).getFirstTime().get(Calendar.DAY_OF_MONTH) + "." + (lessonDefRepository.findByLessonId(l.getLessonId()).get(0).getFirstTime().get(Calendar.MONTH) + 1) + "." + lessonDefRepository.findByLessonId(l.getLessonId()).get(0).getFirstTime().get(Calendar.YEAR);
            lessonDefRepository.findByLessonId(l.getLessonId()).get(0).getFirstTime().add(Calendar.DAY_OF_MONTH, 7);
            lesson.date5 = lessonDefRepository.findByLessonId(l.getLessonId()).get(0).getFirstTime().get(Calendar.DAY_OF_MONTH) + "." + (lessonDefRepository.findByLessonId(l.getLessonId()).get(0).getFirstTime().get(Calendar.MONTH) + 1) + "." + lessonDefRepository.findByLessonId(l.getLessonId()).get(0).getFirstTime().get(Calendar.YEAR);
            modelLessons.add(lesson);
        }
        model.addAttribute("dates", modelLessons);
        System.out.println(Arrays.toString(modelLessons.toArray()));
        return "timetable";
    }
}
