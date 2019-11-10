package hello.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/shop")
public class ShopController {
    public String shop(Model model){

        return "shop";
    }
}
