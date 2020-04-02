package hello.controllers;

import hello.domain.Accounts;
import hello.domain.LessonDef;
import hello.repos.LessonDefRepository;
import hello.repos.LessonRepository;
import hello.repos.PupilReposutory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Controller
public class AndroidResponseController {
    @Autowired
    private PupilReposutory pupilReposutory;

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private LessonDefRepository lessonDefRepository;

    @GetMapping("/getTeacherCourses/{login}/{password}")
    public String getCourses(Model model, @PathVariable String login, @PathVariable String password){
        Accounts teacher = pupilReposutory.findByLoginAndPassword(login, password).isEmpty() ? null : pupilReposutory.findByLoginAndPassword(login, password).get(0);
        if (teacher != null){
            if (teacher.isThisTeacher() || teacher.isThisAdmin()){
                JSONObject courses = new JSONObject();
                JSONArray array = new JSONArray();
                for (LessonDef def :
                        lessonDefRepository.findByTeacherId(teacher.getId())) {
                    array.put(def.getLessonName());
                }
                courses.put("courses", array);
                model.addAttribute("array", courses.toString());
            }
            else model.addAttribute("array", "Go daleko!");
        }
        else model.addAttribute("array", "Go daleko!");
        return "androidArray";
    }

    @GetMapping("/getCourseLessons/{login}/{password}/{lessonName}")
    public String getLessons(Model model, @PathVariable String login, @PathVariable String password, @PathVariable String lessonName){
        Accounts teacher = pupilReposutory.findByLoginAndPassword(login, password).isEmpty() ? null : pupilReposutory.findByLoginAndPassword(login, password).get(0);
        if (teacher != null){
            if (teacher.isThisTeacher() || teacher.isThisAdmin()){
                GregorianCalendar calendar = lessonDefRepository.findByLessonName(lessonName).get(0).getFirstTime();
                JSONArray array = new JSONArray();
                Date now = new Date();
                while (calendar.getTime().before(now)){
                    array.put((((calendar.get(Calendar.DAY_OF_MONTH) > 9 ? "" : "0") + calendar.get(Calendar.DAY_OF_MONTH)) + "." + ((calendar.get(Calendar.MONTH) > 9 ? "" : "0") + (calendar.get(Calendar.MONTH)+1)) + "." + calendar.get(Calendar.YEAR)));
                    calendar.add(Calendar.DAY_OF_MONTH, 7);
                }
                for (int i = 0; i < 2; i++) {
                    array.put((((calendar.get(Calendar.DAY_OF_MONTH) > 9 ? "" : "0") + calendar.get(Calendar.DAY_OF_MONTH)) + "." + ((calendar.get(Calendar.MONTH) > 9 ? "" : "0") + (calendar.get(Calendar.MONTH)+1)) + "." + calendar.get(Calendar.YEAR)));
                    calendar.add(Calendar.DAY_OF_MONTH, 7);
                }
                JSONObject obj = new JSONObject();
                obj.put("lessons", array);
                model.addAttribute("array", obj.toString());
            }
            else model.addAttribute("array", "Go daleko!");
        }
        else model.addAttribute("array", "Go daleko!");
        return "androidArray";
    }
}
