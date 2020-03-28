package hello.controllers;

import hello.domain.Accounts;
import hello.domain.ShopProduct;
import hello.repos.LessonDefRepository;
import hello.repos.ProductRepository;
import hello.repos.PupilReposutory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class AdminController {
    @Autowired
    public PupilReposutory pupilReposutory;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    LessonDefRepository lessonDefRepository;

    @GetMapping("/error")
    public String error(){
        return "error";
    }
    @PostMapping("/error")
    public String errorOnPost(){
        return "error";
    }

    @GetMapping("/adminPanel")
    public String adminPanel(Model model){
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        return "adminPanel";
    }

    @GetMapping("/pupils")
    public String userList(Model model){
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        model.addAttribute("pupils", pupilReposutory.findAll());
        return "userList";
    }
    @GetMapping("/pupils/{pupil}")
    public String userEdit(@PathVariable int pupil, Model model){
        Accounts p = pupilReposutory.findAll().size() == pupil ? new Accounts() : pupilReposutory.findAllById(pupil).get(0);
        model.addAttribute("p", p);
        System.out.println(p.toString());
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        return p.getName() == null ? "redirect:/create" : "userEdit";
    }
    @PostMapping("/pupils")
    public String userSave(@RequestParam("UserId") Accounts pupil, @RequestParam(required = false, defaultValue = "false") boolean isAdmin, @RequestParam(required = false, defaultValue = "false") boolean isTeacher, @RequestParam String name, @RequestParam String surname, Model model){
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        pupil.setName(name);
        pupil.setSurname(surname);
        pupil.setTeacher(isTeacher);
        pupil.setAdmin(isAdmin);
        pupilReposutory.save(pupil);
        return "redirect:/pupils";
    }

    @GetMapping("/create")
    public String createUser(Model model){
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        return "createUser";
    }

    @PostMapping("/create")
    public String saveNewUser(@RequestParam String login, @RequestParam String password, @RequestParam String name, @RequestParam String surname, @RequestParam String url, @RequestParam(required = false, defaultValue = "false") boolean isAdmin, @RequestParam(required = false, defaultValue = "false") boolean isTeacher){
        Accounts pupil = new Accounts(pupilReposutory.findAll().size(), login, password, name, surname, isTeacher, isAdmin, url);
        pupilReposutory.save(pupil);
        return "redirect:/pupils";
    }

    @PostMapping("/deleteUser/{id}")
    public String deleteUser(Model model, @PathVariable int id){
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        pupilReposutory.deleteById(id);
        return "redirect:/pupils";
    }

    // работа с магазином

    @GetMapping("/shopList")
    public String shopList(Model model){
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        model.addAttribute("products", productRepository.findAll());
        return "shopList";
    }

    @GetMapping("/productEdit/{id}")
    public String productEdit(Model model, @PathVariable int id){
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        if (id == productRepository.findAll().size()) return "redirect:/createProduct";
        model.addAttribute("p", productRepository.findAllById(id).get(0));
        return "productEdit";
    }

    @PostMapping("/productEdit/{id}")
    public String saveProduct(Model model, @PathVariable int id, @RequestParam String title, @RequestParam String text, @RequestParam String about, @RequestParam String cost, @RequestParam String imgSrc){
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
    public String createProduct(Model model){
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        return "createProduct";
    }

    @PostMapping("/createProduct")
    public String saveNewProduct(Model model, @RequestParam String title, @RequestParam String text, @RequestParam String about, @RequestParam int cost, @RequestParam String imgSrc){
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
    public String deleteProduct(Model model, @PathVariable int id){
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        productRepository.deleteById(id);
        return "redirect:/shopList";
    }

    //работа с уроками

    @GetMapping("/timetableList")
    public String timetableList(Model model){
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        model.addAttribute("timetables", lessonDefRepository.findAll());
        return "timetableList";
    }

    @GetMapping("/editTimetable/{id}")
    public String editTimetable(Model model, @PathVariable int id){
        model.addAttribute("is", pupilReposutory.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        model.addAttribute("lesson", lessonDefRepository.findByLessonId(id).get(0));
        model.addAttribute("pupils", pupilReposutory.findAll());
        model.addAttribute("teacher", pupilReposutory.findAllById(lessonDefRepository.findByLessonId(id).get(0).getTeacherId()).get(0));
        ArrayList<Accounts> teachers = new ArrayList<>();
        for (Accounts p : pupilReposutory.findAll()) {
            if (p.isThisTeacher()) teachers.add(p);
        }
        model.addAttribute("teachers", teachers);
        return "editTimetable";
    }

}
