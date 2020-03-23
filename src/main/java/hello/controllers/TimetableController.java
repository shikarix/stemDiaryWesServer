package hello.controllers;

import hello.domain.Accounts;
import hello.domain.Homework;
import hello.domain.Lesson;
import hello.domain.LessonDef;
import hello.domain.ModelDomain.LessonTimes;
import hello.repos.HomeworkRepository;
import hello.repos.LessonDefRepository;
import hello.repos.LessonRepository;
import hello.repos.PupilReposutory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class TimetableController {
    @Autowired
    PupilReposutory pupilReposutory;

    @Autowired
    LessonRepository lessonRepository;

    @Autowired
    LessonDefRepository lessonDefRepository;

    @Autowired
    HomeworkRepository homeworkRepository;

    @RequestMapping(path = "/timetable")
    public String timetableList(Model model) {
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        Accounts pupil = pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0);

        ArrayList<Lesson> lessons = pupil.isThisAdmin() ? lessonRepository.findAll() : lessonRepository.findByPupilId(pupil.getId());
        ArrayList<LessonTimes> modelLessons = new ArrayList<>();
        for (Lesson l : lessons) {
            LessonTimes lesson = new LessonTimes();
            lesson.id = l.getLessonId();
            lesson.urlToLessonLogo = lessonDefRepository.findByLessonId(l.getLessonId()).get(0).getUrlToLessonLogo();
            lesson.name = lessonDefRepository.findByLessonId(l.getLessonId()).get(0).getLessonName();
            lesson.time = lessonDefRepository.findByLessonId(l.getLessonId()).get(0).getFirstTime().get(Calendar.HOUR_OF_DAY) + ":" + (lessonDefRepository.findByLessonId(l.getLessonId()).get(0).getFirstTime().get(Calendar.MINUTE) == 0 ? "00" : lessonDefRepository.findByLessonId(l.getLessonId()).get(0).getFirstTime().get(Calendar.MINUTE));
            GregorianCalendar calendar = lessonDefRepository.findByLessonId(l.getLessonId()).get(0).getFirstTime();
            Date dates = calendar.getTime();
            Date date1 = new Date();
            while (!dates.after(date1)){
                calendar.add(Calendar.DAY_OF_MONTH, 7);
                dates = calendar.getTime();
            }
            String hours = calendar.get(Calendar.HOUR_OF_DAY) > 9 ? calendar.get(Calendar.HOUR_OF_DAY) + "" : "0" + calendar.get(Calendar.HOUR_OF_DAY);
            String minutes = calendar.get(Calendar.MINUTE) > 9 ? calendar.get(Calendar.MINUTE) + "" : "0" + calendar.get(Calendar.MINUTE);
            String time = hours + ":" + minutes;
            String date = calendar.get(Calendar.DAY_OF_MONTH) + " " + convertMonth(calendar.get(Calendar.MONTH)) + " " + calendar.get(Calendar.YEAR) + " года";
            lesson.date1 = time + "<br/>" + date;
            lesson.date = calendar.get(Calendar.DAY_OF_MONTH)+"T"+calendar.get(Calendar.MONTH)+"T"+calendar.get(Calendar.YEAR)+"T"+calendar.get(Calendar.HOUR_OF_DAY)+"T"+calendar.get(Calendar.MINUTE);
            lessonDefRepository.findByLessonId(l.getLessonId()).get(0).getFirstTime().add(Calendar.DAY_OF_MONTH, 7);
            modelLessons.add(lesson);
        }
        model.addAttribute("dates", modelLessons);
        return "timetable";
    }

    @RequestMapping("/timetable/{id}/{lesson}")
    public String more(Model model, @PathVariable int id, @PathVariable String lesson) {
        // id - id урока, lesson - время урока
        int[] date = convertDate(lesson);
        GregorianCalendar lessonDate = new GregorianCalendar(date[2], date[1], date[0], date[3], date[4]);

        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        model.addAttribute("isT", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisTeacher());

        model.addAttribute("name", lessonDefRepository.findByLessonId(id).get(0).getLessonName());
        model.addAttribute("date", lessonDate.get(Calendar.DAY_OF_MONTH) + " " + convertMonth(lessonDate.get(Calendar.MONTH)) + " " + lessonDate.get(Calendar.YEAR) + " года");

        String hours = lessonDate.get(Calendar.HOUR_OF_DAY) > 9 ? lessonDate.get(Calendar.HOUR_OF_DAY) + "" : "0" + lessonDate.get(Calendar.HOUR_OF_DAY);
        String minutes = lessonDate.get(Calendar.MINUTE) > 9 ? lessonDate.get(Calendar.MINUTE) + "" : "0" + lessonDate.get(Calendar.MINUTE);
        model.addAttribute("time", (hours + ":" + minutes));

        lessonDate.add(Calendar.DAY_OF_MONTH, -7);
        String pre = lessonDate.get(Calendar.DAY_OF_MONTH)+"T"+lessonDate.get(Calendar.MONTH)+"T"+lessonDate.get(Calendar.YEAR)+"T"+lessonDate.get(Calendar.HOUR_OF_DAY)+"T"+lessonDate.get(Calendar.MINUTE);
        lessonDate.add(Calendar.DAY_OF_MONTH, 14);
        String post = lessonDate.get(Calendar.DAY_OF_MONTH)+"T"+lessonDate.get(Calendar.MONTH)+"T"+lessonDate.get(Calendar.YEAR)+"T"+lessonDate.get(Calendar.HOUR_OF_DAY)+"T"+lessonDate.get(Calendar.MINUTE);
        lessonDate.add(Calendar.DAY_OF_MONTH, -7);
        String now = lessonDate.get(Calendar.DAY_OF_MONTH)+"T"+lessonDate.get(Calendar.MONTH)+"T"+lessonDate.get(Calendar.YEAR)+"T"+lessonDate.get(Calendar.HOUR_OF_DAY)+"T"+lessonDate.get(Calendar.MINUTE);
        model.addAttribute("pre", pre);
        model.addAttribute("post", post);
        model.addAttribute("now", now);

        String homework = homeworkRepository.findByLessonIdAndDate(id, lessonDate).get(0).getHomework();
        model.addAttribute("hw", homework);

        Accounts teacher = pupilReposutory.findAllById(lessonDefRepository.findByLessonId(id).get(0).getTeacherId()).get(0);
        model.addAttribute("teacher", teacher);

        ArrayList<Lesson> lessons = lessonRepository.findByLessonId(id);
        ArrayList<Accounts> pupils = new ArrayList<>();
        for (int i = 0; i < lessons.size(); i++) {
            pupils.add(pupilReposutory.findAllById(lessons.get(i).getPupilId()).get(0));
        }
        model.addAttribute("pupils", pupils);
        model.addAttribute("id", id);
        return "moreAboutLesson";
    }

    @GetMapping("/homework/{dateLesson}/{lesson}")
    public String homework(Model model, @PathVariable String dateLesson, @PathVariable int lesson){
        int[] date = convertDate(dateLesson);
        GregorianCalendar lessonDate = new GregorianCalendar(date[2], date[1], date[0], date[3], date[4]);
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        model.addAttribute("isT", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisTeacher());
        if (!pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisTeacher())
            return "redirect:/profile";
        model.addAttribute("date",lessonDate.get(Calendar.DAY_OF_MONTH)+"T"+lessonDate.get(Calendar.MONTH)+"T"+lessonDate.get(Calendar.YEAR)+"T"+lessonDate.get(Calendar.HOUR_OF_DAY)+"T"+lessonDate.get(Calendar.MINUTE));
        model.addAttribute("lesson", lesson);
        model.addAttribute("name", lessonDefRepository.findByLessonId(lesson).get(0).getLessonName());
        model.addAttribute("homework", homeworkRepository.findByLessonIdAndDate(lesson, lessonDate).get(0).getHomework());
        return "homeworkEdit";
    }

    @PostMapping("/homework/{dateLesson}/{lesson}")
    public String saveHomework(Model model, @PathVariable String dateLesson, @PathVariable int lesson, @RequestParam String homework){
        int[] date = convertDate(dateLesson);
        homework = homework.trim();
        GregorianCalendar lessonDate = new GregorianCalendar(date[2], date[1], date[0], date[3], date[4]);
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        model.addAttribute("isT", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisTeacher());
        Homework thisHomework = homeworkRepository.findByLessonIdAndDate(lesson, lessonDate).get(0);
        thisHomework.setHomework(homework);
        homeworkRepository.save(thisHomework);
        String now = lessonDate.get(Calendar.DAY_OF_MONTH)+"T"+lessonDate.get(Calendar.MONTH)+"T"+lessonDate.get(Calendar.YEAR)+"T"+lessonDate.get(Calendar.HOUR_OF_DAY)+"T"+lessonDate.get(Calendar.MINUTE);
        return "redirect:/timetable/"+lesson+"/"+now;
    }
    @GetMapping("/addlesson")
    public String addLesson(Model model){
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        ArrayList<String> teachers = new ArrayList<>();
        ArrayList<Accounts> all = pupilReposutory.findAll();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).isThisTeacher()){
                teachers.add(all.get(i).getName() + " " + all.get(i).getSurname());
            }
        }
        model.addAttribute("teachers", teachers);
        return "addLesson";
    }

    @PostMapping("/addlesson")
    public String saveLesson(Model model, @RequestParam String name, @RequestParam String date, @RequestParam String url, @RequestParam String teacher){
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        int[] dateConvert = convertDateFromSaveLesson(date);
        GregorianCalendar lessonDate = new GregorianCalendar(dateConvert[2], dateConvert[1], dateConvert[0], dateConvert[3], dateConvert[4]);

        LessonDef def = new LessonDef();
        def.setFirstTime(lessonDate);
        def.setLessonName(name);
        def.setLessonId(lessonDefRepository.findAll().size() + 1);
        def.setTeacherId(pupilReposutory.findByName(teacher.split(" ")[0]).get(0).getId());
        def.setUrlToLessonLogo(url);
        System.out.println(def.toString());
        lessonDefRepository.save(def);

        return "redirect:/timetable";
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
    public static int[] convertDate(String calendar){
        int[] date = new int[5];
        String[] data = calendar.split("T");
        System.out.println(calendar);
        System.out.println(Arrays.toString(data));
        date[0] = Integer.parseInt(data[0]);
        date[1] = Integer.parseInt(data[1]);
        date[2] = Integer.parseInt(data[2]);
        date[3] = Integer.parseInt(data[3]);
        date[4] = Integer.parseInt(data[4]);
        System.out.println(Arrays.toString(date));
        return date;
    }
    public static int[] convertDateFromSaveLesson(String calendar){
        int[] date = new int[5];
        String[] data = calendar.split(" ");
        System.out.println(calendar);
        System.out.println(Arrays.toString(data));
        date[0] = Integer.parseInt(data[0]);
        date[1] = Integer.parseInt(data[1]);
        date[2] = Integer.parseInt(data[2]);
        date[3] = Integer.parseInt(data[3]);
        date[4] = Integer.parseInt(data[4]);
        System.out.println(Arrays.toString(date));
        return date;
    }

    @RequestMapping("/test")
    public String test(Model model) {
        model.addAttribute("isAdmin", "true");
        return "navbar";
    }
}