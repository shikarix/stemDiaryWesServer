package hello.controllers;

import hello.domain.ShopProduct;
import hello.repos.ProductRepository;
import hello.repos.PupilReposutory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ShopAndroidController {
    @Autowired
    ProductRepository prodRepo;
    @Autowired
    PupilReposutory repo;

    @GetMapping("/androidShop/{login}/{pass}")
    public String getShop(Model model, @PathVariable String login, @PathVariable String pass){
        if (!repo.findByLoginAndPassword(login, pass).isEmpty()) {
            List<ShopProduct> products = prodRepo.findAll();
            JSONArray array = new JSONArray();
            System.out.println(products);
            for (int i = 0; i < products.size(); i++) {
                JSONObject object = new JSONObject();
                object.put("title", products.get(i).getTitle());
                object.put("imgSrc", products.get(i).getImgSrc());
                object.put("cost", products.get(i).getCost());
                array.put(object);
            }
            model.addAttribute("strings", array.toString());
            System.out.println(array);
        }
        return "shopAndroid";
    }
}
