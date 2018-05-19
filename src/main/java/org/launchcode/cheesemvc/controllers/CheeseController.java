package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by AllynHD (with help from Chris "NotMichael" Bay and LaunchCode
 */
@Controller
@RequestMapping("cheese") // URL Prefix, so every handler requires prefix
public class CheeseController {

    static ArrayList<Cheese> cheeses = new ArrayList<>();


    // Request path: /cheese
    @RequestMapping(value = "") // Removed @RequestBody
    public String index(Model model) {

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheeses");
        return "cheese/index"; // takes in template name, not file name
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String cheeseDescription) {
        Cheese newCheese = new Cheese(cheeseName, cheeseDescription);
        newCheese.setCheeseName(cheeseName);
        newCheese.setCheeseDescription(cheeseDescription);
        cheeses.add(newCheese);

        // Redirect to /cheese
        return "redirect:"; //Because it's blank, it redirects to the /cheese route (from Controller, + "")
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String removeCheese(Model model) {
        model.addAttribute("title", "Remove Cheeses");
        model.addAttribute("cheeses", cheeses);
        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String removeCheeseConfirm(@RequestParam ArrayList<String> cheeseList) {

        for (Cheese cheese : new ArrayList<>(cheeses)) {
            if (cheeseList.contains(cheese.cheeseName)) {
                cheeses.remove(cheese);
            }

        }

        return "redirect:";
    }
}
