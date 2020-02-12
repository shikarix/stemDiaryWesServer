package hello.controllers;

import hello.domain.Accounts;
import hello.repos.PupilReposutory;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

@Controller
public class GreetingController {
    boolean was = false;
    String objectPupil = "{\"login\":\"user\", \"password\":\"12345\", \"name\":\"Алексей\", \"surname\":\"Васильев\",\"stemCoins\":100, \"accessType\":\"admin\", \"avatarUrl\":\"https://static.tildacdn.com/tild6165-3663-4664-a234-643430613238/-07.png\"}";
    @Autowired
    private PupilReposutory pupilRepository;
    @Autowired
    private DataSource dataSource;

    @GetMapping(value = "/")
    public String greetingForm(Model model) {
        return add(model);
    }

    @PostMapping(path = "/profile")
    public String editMe(@RequestParam String oldPassword, @RequestParam String newPassword, @RequestParam String againPassword, Model model) {
        Iterable<Accounts> pupils = pupilRepository.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        ArrayList<Accounts> pupil = new ArrayList<>();
        pupils.forEach(pupil::add);
        Accounts need = pupil.get(0);
        if (oldPassword != null)
            if (!oldPassword.equals(" ") && !oldPassword.equals("")) {
                if (oldPassword.equals(need.getPassword())) {
                    if (newPassword != null)
                        if (!newPassword.equals("")) {
                            if (againPassword != null)
                                if (newPassword.equals(againPassword)) {
                                    need.setPassword(againPassword);
                                    model.addAttribute("warn", "Вы изменили пароль!");
                                    return add(model);
                                } else {
                                    model.addAttribute("warn", "Новые пароли не совпадают!");
                                    return add(model);
                                }
                        } else {
                            model.addAttribute("warn", "Если хотите изменить пароль, то введите новый пароль!");
                            return add(model);
                        }
                } else {
                    model.addAttribute("warn", "Введите свой старый пароль!");
                    return add(model);
                }
            }
        pupilRepository.save(pupil.get(0));
        return add(model);
    }

    @GetMapping(path = "/profile")
    public String profile(Model model) {
        return add(model);
    }

    @RequestMapping(path = "/editMe")
    public String add(Model model) {
        Iterable<Accounts> pupils = pupilRepository.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("pupils", pupils);
        ArrayList<Accounts> pupil = new ArrayList<>();
        pupils.forEach(pupil::add);
        pupilRepository.save(pupil.get(0));
        if (model.asMap().get("warn") == null || model.asMap().get("warn").equals("")) model.addAttribute("warn", "");
        return "editMe";
    }

    public void createSocket(ServerSocket server) throws Exception {
        System.out.println("!");
        Socket socket = server.accept();
        System.out.println("!");
        new Thread() {
            @Override
            public void run() {
                try {
                    DataInputStream dis = new DataInputStream(socket.getInputStream());
                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                    String disString = dis.readUTF();
                    System.out.println(disString);
                    JSONObject object = new JSONObject(disString);
                    JSONObject pupil = new JSONObject(objectPupil);
                    if (pupil.getString("login").equals(object.getString("login"))) {
                        Accounts p = new Accounts();
                        p.setName(pupil.getString("name"));
                        p.setSurname(pupil.getString("surname"));
                        p.setStemCoins(pupil.getInt("stemCoins"));
                        p.setAvatarUrl(pupil.getString("avatarUrl"));
                        dos.writeUTF(
                                "{\" name \":\"" + p.getName() + "\"," +
                                        "\" surname \":\"" + p.getSurname() + "\"," +
                                        "\" accessType \":\"" + pupil.getString("accessType") + "\"," +
                                        "\" coins \":\"" + p.getStemCoins() + "\"," +
                                        "\" avatarUrl \":\"" + p.getAvatarUrl() + "\"}"
                        );
                        System.out.println("{\" name \":\"" + p.getName() + "\"," +
                                "\" surname \":\"" + p.getSurname() + "\"," +
                                "\" accessType \":\"" + pupil.getString("accessType") + "\"," +
                                "\" coins \":\"" + p.getStemCoins() + "\"," +
                                "\" avatarUrl \":\"" + p.getAvatarUrl() + "\"}");
                    } else dos.writeUTF("Go daleko!");

                    dos.flush();
                    dos.close();
                    dis.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                try {
                    createSocket(server);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}