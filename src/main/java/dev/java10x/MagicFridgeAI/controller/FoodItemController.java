package dev.java10x.MagicFridgeAI.controller;

import dev.java10x.MagicFridgeAI.model.FoodItem;
import dev.java10x.MagicFridgeAI.service.FoodItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodItemController {

    private final FoodItemService service;

    public FoodItemController(FoodItemService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FoodItem> criar(@RequestBody FoodItem foodItem) {
        FoodItem salvo = service.salvar(foodItem);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(salvo);
    }

    @GetMapping
    public ResponseEntity<List<FoodItem>> listar() {
        List<FoodItem> lista = service.listar();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodItem> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FoodItem> atualizar(
            @PathVariable Long id,
            @RequestBody FoodItem foodItem) {

        FoodItem atualizado =
                service.atualizar(id, foodItem);

        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }


}
