package hello.controllers;

import hello.domain.ShopProduct;
import hello.repos.ProductRepository;
import hello.repos.PupilReposutory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired
    PupilReposutory pupilRepository;

    @GetMapping
    public String shop(Model model) {
        model.addAttribute("is", pupilRepository.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isAdmin());
        Iterable<ShopProduct> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "shop";
    }

    @PostMapping
    public String filter(@RequestParam String name, @RequestParam Integer cost, Model model) {
        model.addAttribute("is", pupilRepository.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isAdmin());
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
        model.addAttribute("is", pupilRepository.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isAdmin());
        if (shopProduct.getImgSrc().equals("")) {
            shopProduct.setImgSrc("https://vk.com/photo-113376999_457241099https://vk.com/photo-113376999_457241099");
        }
        model.addAttribute("product", shopProduct);
        return "product";
    }

}
