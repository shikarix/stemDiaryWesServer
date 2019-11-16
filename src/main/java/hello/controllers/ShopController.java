package hello.controllers;

import hello.domain.ShopProduct;
import hello.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/shop")
public class ShopController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public String shop(Model model){
        Iterable<ShopProduct> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "shop";
    }
    @PostMapping()
    public String filter(@RequestParam String name, @RequestParam int cost, Model model){
        Iterable<ShopProduct> products = productRepository.findByTitleAndCost(name, cost);
        model.addAttribute("products", products);
        return "shop";
    }

}
