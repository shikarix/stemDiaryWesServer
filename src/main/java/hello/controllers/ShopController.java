package hello.controllers;

import hello.domain.ShopProduct;
import hello.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/shop")
public class ShopController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public String shop(Model model){
        productRepository.save(new ShopProduct());
        ShopProduct shopProduct = productRepository.findByCost(0).get(0);
        System.out.println(shopProduct.toString());
        return "shop";
    }
}
