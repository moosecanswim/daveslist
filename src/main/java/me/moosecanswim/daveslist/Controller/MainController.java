package me.moosecanswim.daveslist.Controller;

import me.moosecanswim.daveslist.Model.House;
import me.moosecanswim.daveslist.Repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/add")
    public String addListingGet(Model toSend){
        toSend.addAttribute("isNew",true);
        toSend.addAttribute("aHouse", new House());
        return "listingForm";
    }
    @RequestMapping("/process/{id}")
    public String processListing(@PathVariable("id") long id,@Valid House aHouse, BindingResult result){
        if(result.hasErrors()){
            return "listingForm";
        }
        houseRepository.save(aHouse);
        return "redirect:/showListings";
    }


    @RequestMapping("/showListings")
    public String showListingGet(Model model){
        Iterable<House> tempFindAll = houseRepository.findAll();
        model.addAttribute("allListings",tempFindAll);

        Iterable<House> tempFindAvalible = houseRepository.findByRented("Avalible");
        model.addAttribute("avalibleListings",tempFindAvalible);

        Iterable<House> tempFindUnavalible = houseRepository.findByRented("Unavalible");
        model.addAttribute("unavalibleListings",tempFindUnavalible);
        return "showListings";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id){
        houseRepository.delete(id);
        return "redirect:/showListings";
    }
    @RequestMapping("/update/{id}")
    public String update(@PathVariable("id") long id,Model model){
        model.addAttribute("isNew",false);
        model.addAttribute("aHouse",houseRepository.findOne(id));
        return "listingForm";
    }




}
