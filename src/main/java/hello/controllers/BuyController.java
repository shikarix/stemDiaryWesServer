package hello.controllers;

import hello.domain.Accounts;
import hello.domain.Purchase;
import hello.domain.ShopProduct;
import hello.repos.ProductRepository;
import hello.repos.PupilReposutory;
import hello.repos.PurchaseRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BuyController {
    @Autowired
    PurchaseRepository purRepo;

    @Autowired
    ProductRepository repo;

    @Autowired
    PupilReposutory pupilRepo;

    @RequestMapping("/buy/{id}/{login}/{pass}")
    public String buy(Model model, @PathVariable int id, @PathVariable String login, @PathVariable String pass) {
        ShopProduct product = repo.findById(id).get();
        Accounts pupil = pupilRepo.findByLoginAndPassword(login, pass).get(0);
        JSONObject object = new JSONObject();
        if (pupil.getStemCoins() < product.getCost()) object.put("isBuy", false);
        else {
            object.put("isBuy", true);
            if (id == 3){
                pupil.setAvatarUrl("https://camo.githubusercontent.com/20232135c459ea65f3b35e4c779725bc789b4c9c/687474703a2f2f6f63746f6465782e6769746875622e636f6d2f696d616765732f646f6a6f6361742e6a7067");
            }
            else{
                purRepo.save(new Purchase(id, login));
            }
            object.put("balance", (pupil.getStemCoins() - product.getCost()));
            pupil.setStemCoins(pupil.getStemCoins() - product.getCost());
            pupilRepo.save(pupil);
        }
        model.addAttribute("strings", object);
        return "buy";
    }

}
