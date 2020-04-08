package hello.controllers;

import hello.domain.Accounts;
import hello.domain.Lesson;
import hello.domain.LessonDef;
import hello.domain.Mark;
import hello.repos.LessonDefRepository;
import hello.repos.LessonRepository;
import hello.repos.MarkRepository;
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

    @Autowired
    private MarkRepository markRepository;

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

    @GetMapping("/getLessonStudents/{login}/{password}/{lessonName}")
    public String getStudents(Model model, @PathVariable String login, @PathVariable String password, @PathVariable String lessonName){
        Accounts teacher = pupilReposutory.findByLoginAndPassword(login, password).isEmpty() ? null : pupilReposutory.findByLoginAndPassword(login, password).get(0);
        if (teacher != null){
            if (teacher.isThisTeacher() || teacher.isThisAdmin()){
                LessonDef def = lessonDefRepository.findByLessonName(lessonName).get(0);
                JSONArray array = new JSONArray();
                for (Lesson l :
                        lessonRepository.findByLessonId(def.getLessonId())) {
                    array.put(pupilReposutory.findAllById(l.getPupilId()).get(0).getName() + " " + pupilReposutory.findAllById(l.getPupilId()).get(0).getSurname());
                }
                JSONObject obj = new JSONObject();
                obj.put("students", array);
                model.addAttribute("array", obj.toString());
            }
            else model.addAttribute("array", "Go daleko!");
        }
        else model.addAttribute("array", "Go daleko!");
        return "androidArray";
    }

    @GetMapping("/setStudentRate/{tLogin}/{tPassword}/{lessonName}/{date}/{behaviour}/{doing}/{extra}/{name}/{surname}")
    public String setRate(Model model, @PathVariable String tLogin, @PathVariable String tPassword, @PathVariable String lessonName, @PathVariable String date, @PathVariable int behaviour, @PathVariable int doing, @PathVariable int extra, @PathVariable String name, @PathVariable String surname){
//        model.addAttribute("array", true);
        if (!pupilReposutory.findByLoginAndPassword(tLogin, tPassword).isEmpty()){
            if (pupilReposutory.findByLoginAndPassword(tLogin, tPassword).get(0).isThisTeacher()){
                if (doing > 0 && doing < 6 && extra > 0 && extra < 6 && behaviour > 0 && behaviour < 6){
                    Mark mark = !markRepository.findByDateAndPupilId(covertDate(date), pupilReposutory.findByNameAndSurname(name, surname).get(0).getId()).isEmpty() ? markRepository.findByDateAndPupilId(covertDate(date), pupilReposutory.findByNameAndSurname(name, surname).get(0).getId()).get(0) : new Mark();
                    mark.setDate(covertDate(date));
                    mark.setPupilId(pupilReposutory.findByNameAndSurname(name, surname).get(0).getId());
                    mark.setBehaviourMark(behaviour);
                    mark.setLessonDoingMark(doing);
                    mark.setHomeworkDoingMark(extra);
                    mark.setLessonId(lessonDefRepository.findByLessonName(lessonName).get(0).getLessonId());
                    mark.setTotalStemCoins((doing + behaviour + extra)/3);
                    markRepository.save(mark);
                }
            }
        }
        return "androidArray";
    }

    public GregorianCalendar covertDate(String date){
        //"YYYY-MM-DD HH:MM"
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, Integer.parseInt(date.split(" ")[0].split("-")[0]));
        calendar.set(Calendar.MONTH, Integer.parseInt(date.split(" ")[0].split("-")[1]));
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(date.split(" ")[0].split("-")[2]));
        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(date.split(" ")[1].split(":")[0]));
        calendar.set(Calendar.MINUTE, Integer.parseInt(date.split(" ")[1].split(":")[1]));
        return calendar;
    }
}
