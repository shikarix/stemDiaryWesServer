package hello.controllers;

import hello.domain.ShopProduct;
import hello.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/shop")
public class ShopController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public String shop(Model model) {
        Iterable<ShopProduct> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "shop";
    }

    @PostMapping
    public String filter(@RequestParam String name, @RequestParam Integer cost, Model model) {
        List<ShopProduct> products;
        if (!name.equals("") && cost != null) {
            products = productRepository.findByTitleContaining(name);
            List<ShopProduct> costProducts = new ArrayList<>();
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getCost() == cost) costProducts.add(products.get(i));
            }
            products = costProducts;
        } else if (!name.equals("")) products = productRepository.findByTitleContaining(name);
        else if (cost != null) products = productRepository.findByCost(cost);
        else products = productRepository.findAll();

        model.addAttribute("products", products);
        return "shop";
    }

    @GetMapping(path = "{shopProduct}")
    public String product(@PathVariable ShopProduct shopProduct, Model model) {
        if (shopProduct.getImgSrc().equals("")) {
            shopProduct.setImgSrc("https://vk.com/photo-113376999_457241099https://vk.com/photo-113376999_457241099");
        }
        model.addAttribute("product", shopProduct);
        return "product";
    }

}
