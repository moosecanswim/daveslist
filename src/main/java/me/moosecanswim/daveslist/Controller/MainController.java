package me.moosecanswim.daveslist.Controller;

import me.moosecanswim.daveslist.Model.House;
import me.moosecanswim.daveslist.Repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class MainController {

    @Autowired
    HouseRepository houseRepository;

    @GetMapping("/")
    public String homeGet(){

        return "home";
    }

    @GetMapping("/addListing")
    public String addListingGet(Model toSend){
        ArrayList<String> forAvalability = new ArrayList<String>();
        forAvalability.add("Avalible");forAvalability.add("Unavalible");


        toSend.addAttribute("aHouse", new House());
        toSend.addAttribute("avalibleList", forAvalability);
        return "addListing";
    }
    @PostMapping("/addListing")
    public String addListingPost(@Valid @ModelAttribute("aHouse") House aHouse, BindingResult result){
        System.out.println(result.toString());
        if(result.hasErrors()){
            return "addListing";
        }

        houseRepository.save(aHouse);
        return "addListingConfirm";
    }

    @GetMapping("/showListings")
    public String showListingGet(){

        return "showListing";
    }
    @PostMapping("/showLIstings")
    public String showListingPost(){

        return "showListing";
    }

}
