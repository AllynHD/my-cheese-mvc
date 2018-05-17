package org.launchcode.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created by AllynHD (with help from Chris "NotMichael" Bay and LaunchCode
 */
@Controller
@RequestMapping("cheese") // URL Prefix, so every handler requires prefix
public class CheeseController {

    static HashMap<String, String> cheeses = new HashMap<>();


    // Request path: /cheese
    @RequestMapping(value = "") // Removed @RequestBody
    public String index(Model model) {

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "PotatoHead");
        return "cheese/index"; // takes in template name, not file name
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String cheeseDescription) {
        cheeses.put(cheeseName, cheeseDescription);

        // Redirect to /cheese
        return "redirect:"; //Because it's blank, it redirects to the /cheese route (from Controller, + "")
    }

}

