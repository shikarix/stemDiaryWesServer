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
            if (teacher.isThisTeacher()){
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
}
