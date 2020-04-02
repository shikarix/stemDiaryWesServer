package hello.controllers;

import hello.domain.Accounts;
import hello.domain.Lesson;
import hello.domain.LessonDef;
import hello.domain.ShopProduct;
import hello.repos.LessonDefRepository;
import hello.repos.LessonRepository;
import hello.repos.ProductRepository;
import hello.repos.PupilReposutory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Controller
public class AdminController {
    @Autowired
    public PupilReposutory pupilReposutory;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    LessonDefRepository lessonDefRepository;

    @Autowired
    LessonRepository lessonRepository;

    @GetMapping("/error")
    public String error() {
        return "error";
    }

    @PostMapping("/error")
    public String errorOnPost() {
        return "error";
    }

    @GetMapping("/adminPanel")
    public String adminPanel(Model model) {
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        return "adminPanel";
    }

    @GetMapping("/pupils")
    public String userList(Model model) {
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        model.addAttribute("pupils", pupilReposutory.findAll());
        return "userList";
    }

    @GetMapping("/pupils/{pupil}")
    public String userEdit(@PathVariable int pupil, Model model) {
        Accounts p = pupilReposutory.findAll().size() == pupil ? new Accounts() : pupilReposutory.findAllById(pupil).get(0);
        model.addAttribute("p", p);
        System.out.println(p.toString());
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        return p.getName() == null ? "redirect:/create" : "userEdit";
    }

    @PostMapping("/pupils")
    public String userSave(@RequestParam("UserId") Accounts pupil, @RequestParam(required = false, defaultValue = "false") boolean isAdmin, @RequestParam(required = false, defaultValue = "false") boolean isTeacher, @RequestParam String name, @RequestParam String surname, Model model) {
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        pupil.setName(name);
        pupil.setSurname(surname);
        pupil.setTeacher(isTeacher);
        pupil.setAdmin(isAdmin);
        pupilReposutory.save(pupil);
        return "redirect:/pupils";
    }

    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        return "createUser";
    }

    @PostMapping("/create")
    public String saveNewUser(@RequestParam String login, @RequestParam String password, @RequestParam String name, @RequestParam String surname, @RequestParam String url, @RequestParam(required = false, defaultValue = "false") boolean isAdmin, @RequestParam(required = false, defaultValue = "false") boolean isTeacher) {
        Accounts pupil = new Accounts(pupilReposutory.findAll().size(), login, password, name, surname, isTeacher, isAdmin, url);
        pupilReposutory.save(pupil);
        return "redirect:/pupils";
    }

    @PostMapping("/deleteUser/{id}")
    public String deleteUser(Model model, @PathVariable int id) {
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        pupilReposutory.deleteById(id);
        return "redirect:/pupils";
    }

    // работа с магазином

    @GetMapping("/shopList")
    public String shopList(Model model) {
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        model.addAttribute("products", productRepository.findAll());
        return "shopList";
    }

    @GetMapping("/productEdit/{id}")
    public String productEdit(Model model, @PathVariable int id) {
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        if (id == productRepository.findAll().size()) return "redirect:/createProduct";
        model.addAttribute("p", productRepository.findAllById(id).get(0));
        return "productEdit";
    }

    @PostMapping("/productEdit/{id}")
    public String saveProduct(Model model, @PathVariable int id, @RequestParam String title, @RequestParam String text, @RequestParam String about, @RequestParam String cost, @RequestParam String imgSrc) {
        int thisCost = Integer.parseInt(cost);
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        ShopProduct product = productRepository.findAllById(id).get(0);
        product.setTitle(title);
        product.setText(text);
        product.setAbout(about);
        product.setCost(thisCost);
        product.setImgSrc(imgSrc);
        productRepository.save(product);
        return "redirect:/shopList";
    }

    @GetMapping("/createProduct")
    public String createProduct(Model model) {
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        return "createProduct";
    }

    @PostMapping("/createProduct")
    public String saveNewProduct(Model model, @RequestParam String title, @RequestParam String text, @RequestParam String about, @RequestParam int cost, @RequestParam String imgSrc) {
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        ShopProduct p = new ShopProduct();
        p.setTitle(title);
        p.setText(text);
        p.setAbout(about);
        p.setCost(cost);
        p.setImgSrc(imgSrc);
        productRepository.save(p);
        return "redirect:/shopList";
    }

    @PostMapping("/deleteProduct/{id}")
    public String deleteProduct(Model model, @PathVariable int id) {
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        productRepository.deleteById(id);
        return "redirect:/shopList";
    }

    //работа с уроками

    @GetMapping("/timetableList")
    public String timetableList(Model model) {
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        model.addAttribute("timetables", lessonDefRepository.findAll());
        return "timetableList";
    }

    @GetMapping("/editTimetable/{id}")
    public String editTimetable(Model model, @PathVariable int id) {
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        model.addAttribute("lesson", lessonDefRepository.findByLessonId(id).get(0));
        model.addAttribute("teacher", pupilReposutory.findAllById(lessonDefRepository.findByLessonId(id).get(0).getTeacherId()).isEmpty() ? null : pupilReposutory.findAllById(lessonDefRepository.findByLessonId(id).get(0).getTeacherId()).get(0));
        GregorianCalendar date = lessonDefRepository.findByLessonId(id).get(0).getFirstTime();
        model.addAttribute("date", date.get(Calendar.YEAR) + "-" + ((date.get(Calendar.MONTH) + 1 > 9 ? "" : "0") + (date.get(Calendar.MONTH) + 1)) + "-" + ((date.get(Calendar.DAY_OF_MONTH) > 9 ? "" : "0") + date.get(Calendar.DAY_OF_MONTH)));
        model.addAttribute("time", (date.get(Calendar.HOUR_OF_DAY) > 9 ? "" : "0") + date.get(Calendar.HOUR_OF_DAY) + ":" + (date.get(Calendar.MINUTE) > 9 ? "" : "0") + date.get(Calendar.MINUTE));
        ArrayList<Accounts> teachers = new ArrayList<>();
        ArrayList<Accounts> pupils = new ArrayList<>();
        for (Accounts p : pupilReposutory.findAll()) {
            if (p.isThisTeacher()) teachers.add(p);
            if (!p.isThisTeacher() && !p.isThisAdmin()) pupils.add(p);
        }
        for (Lesson l : lessonRepository.findByLessonId(id)) {
            pupilReposutory.findAllById(l.getPupilId()).get(0).setHere(true);
        }
        model.addAttribute("teachers", teachers);
        model.addAttribute("pupils", pupils);
        return "editTimetable";
    }

    @PostMapping("/editTimetable/{id}")
    public String saveTimetable(Model model, @PathVariable int id, @RequestParam int teacher, @RequestParam String name, @RequestParam String date, @RequestParam String url, @RequestParam String time, @RequestParam(required = false) int... check) {
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        ArrayList<Lesson> wasInLesson = lessonRepository.findByLessonId(id);
        for (int i = 0; i < wasInLesson.size(); i++) {
            lessonRepository.delete(wasInLesson.get(i));
        }
        if (check != null)
            for (int i = 0; i < check.length; i++) {
                Lesson lesson = lessonRepository.findByLessonIdAndPupilId(id, check[i]).isEmpty() ? new Lesson() : lessonRepository.findByLessonIdAndPupilId(id, check[i]).get(0);
                lesson.setLessonId(id);
                lesson.setPupilId(check[i]);
                lessonRepository.save(lesson);
            }
        LessonDef def = lessonDefRepository.findByLessonId(id).get(0);
        def.setTeacherId(teacher);
        def.setUrlToLessonLogo(url);
        def.setLessonName(name);
        GregorianCalendar firstDate = getDateFromForm(date);
        firstDate.set(Calendar.MINUTE, getTimeFromForm(time).get(Calendar.MINUTE));
        firstDate.set(Calendar.HOUR_OF_DAY, getTimeFromForm(time).get(Calendar.HOUR_OF_DAY));
        def.setFirstTime(firstDate);
        lessonDefRepository.save(def);
        return "redirect:/timetableList";
    }

    @PostMapping("/deleteLesson/{id}")
    public String deleteTimetable(Model model, @PathVariable int id) {
        ArrayList<Lesson> lessons = lessonRepository.findByLessonId(id);
        for (Lesson l : lessons) {
            lessonRepository.delete(l);
        }
        lessonDefRepository.delete(lessonDefRepository.findByLessonId(id).get(0));
        return "redirect:/timetableList";
    }

    @GetMapping("/createTimetable")
    public String createTimetable(Model model) {
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        ArrayList<Accounts> pupils = new ArrayList<>();
        ArrayList<Accounts> teachers = new ArrayList<>();
        for (Accounts p : pupilReposutory.findAll()) {
            if (p.isThisTeacher()) teachers.add(p);
            if (!p.isThisTeacher() && !p.isThisAdmin()) pupils.add(p);
        }
        model.addAttribute("teachers", teachers);
        model.addAttribute("pupils", pupils);
        return "createTimetable";
    }

    @PostMapping("/createTimetable")
    public String saveNewTimetable(Model model, @RequestParam int teacher, @RequestParam String name, @RequestParam String date, @RequestParam String url, @RequestParam String time, @RequestParam(required = false) int... check) {
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());

        LessonDef def = new LessonDef();
        def.setTeacherId(teacher);
        def.setUrlToLessonLogo(url);
        def.setLessonName(name);
        GregorianCalendar firstDate = getDateFromForm(date);
        firstDate.set(Calendar.MINUTE, getTimeFromForm(time).get(Calendar.MINUTE));
        firstDate.set(Calendar.HOUR_OF_DAY, getTimeFromForm(time).get(Calendar.HOUR_OF_DAY));
        def.setFirstTime(firstDate);
        lessonDefRepository.save(def);

        if (check != null)
            for (int i = 0; i < check.length; i++) {
                Lesson lesson = new Lesson();
                lesson.setLessonId(def.getLessonId());
                lesson.setPupilId(check[i]);
                lessonRepository.save(lesson);
            }

        return "redirect:/timetableList";
    }

    public GregorianCalendar getDateFromForm(String date) {
        GregorianCalendar calendar = new GregorianCalendar();
        String data[] = date.split("-");
        int[] nums = new int[data.length];
        int i = 0;
        for (String a : data) {
            nums[i++] = Integer.parseInt(a);
        }
        calendar.set(Calendar.YEAR, nums[0]);
        calendar.set(Calendar.MONTH, (nums[1] - 1));
        calendar.set(Calendar.DAY_OF_MONTH, nums[2]);
        return calendar;
    }

    public GregorianCalendar getTimeFromForm(String time){
        GregorianCalendar calendar = new GregorianCalendar();
        String data[] = time.split(":");
        int[] nums = new int[data.length];
        int i = 0;
        for (String a : data) {
            nums[i++] = Integer.parseInt(a);
        }
        calendar.set(Calendar.HOUR_OF_DAY, nums[0]);
        calendar.set(Calendar.MINUTE, nums[1]);
        return calendar;
    }
}
