package hello.controllers;

import hello.domain.Accounts;
import hello.repos.ProductRepository;
import hello.repos.PupilReposutory;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping(path = "/database")
public class DatabaseControllerForAndroid {
    @Autowired
    private PupilReposutory pupils;

    @Autowired
    private ProductRepository products;

    @GetMapping("{login}/{password}")
    public String show(Model model, @PathVariable String login, @PathVariable String password) {
        char[] log = login.toCharArray();
        login = "";
        for (int i = 0; i < log.length; i++) {
            log[i] = (char) ((int) log[i] - 50);
            login += log[i];
        }
        char[] pass = password.toCharArray();
        password = "";
        for (int i = 0; i < pass.length; i++) {
            pass[i] = (char) ((int) pass[i] - 50);
            password += pass[i];
        }

        ArrayList<String> strings = new ArrayList<>();
        Iterable<Accounts> pupilsList = pupils.findByLoginAndPassword(login, password);
        ArrayList<Accounts> pupilsArray = new ArrayList<>();
        pupilsList.forEach(pupilsArray::add);
        for (int i = 0; i < pupilsArray.size(); i++) {
            JSONObject object = new JSONObject();
            object.put("login", pupilsArray.get(i).getLogin());
            object.put("password", pupilsArray.get(i).getPassword());
            object.put("name", pupilsArray.get(i).getName());
            object.put("surname", pupilsArray.get(i).getSurname());
            object.put("stemCoins", pupilsArray.get(i).getStemCoins());
            if (pupilsArray.get(i).isThisAdmin()) {
                object.put("accessType", "ADMIN");
            } else if (pupilsArray.get(i).isThisTeacher()) {
                object.put("accessType", "TEACHER");
            } else object.put("accessType", "PUPIL");
            object.put("avatarUrl", pupilsArray.get(i).getAvatarUrl());
            strings.add(object.toString());
            System.out.println(object.toString());
        }
        model.addAttribute("strings", strings);
        String string = strings.toString();
        System.out.println(string);
        return "database";
    }
}
