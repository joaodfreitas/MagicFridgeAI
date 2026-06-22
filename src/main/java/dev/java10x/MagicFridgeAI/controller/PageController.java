package dev.java10x.MagicFridgeAI.controller;

import dev.java10x.MagicFridgeAI.service.FoodItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    private final FoodItemService foodItemService;

    public PageController(FoodItemService foodItemService){
        this.foodItemService = foodItemService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/novo")
    public String novoAlimento() {
        return "novo-alimento";
    }

    @GetMapping("/receita")
    public String receita() {
        return "receita";
    }

    @GetMapping("/foods")
    public String listar(Model model){

        model.addAttribute(
                "foods",
                foodItemService.listar()
        );

        return "foods";
    }
}
