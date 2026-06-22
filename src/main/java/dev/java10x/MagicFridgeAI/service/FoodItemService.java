package dev.java10x.MagicFridgeAI.service;

import dev.java10x.MagicFridgeAI.model.FoodItem;
import dev.java10x.MagicFridgeAI.repository.FoodItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemService {

    private final FoodItemRepository repository;

    public FoodItemService(FoodItemRepository repository) {
        this.repository = repository;
    }

    public FoodItem salvar(FoodItem foodItem) {
        return repository.save(foodItem);
    }

    public List<FoodItem> listar() {
        return repository.findAll();
    }

    public FoodItem buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Item não encontrado"));
    }


    public FoodItem atualizar(Long id, FoodItem foodItem) {
        FoodItem itemExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));
        itemExistente.setNome(foodItem.getNome());
        itemExistente.setCategoria(foodItem.getCategoria());
        itemExistente.setQuantidade(foodItem.getQuantidade());
        itemExistente.setValidade(foodItem.getValidade());

        return repository.save(itemExistente);

    }


    public void deletar(Long id) {
        FoodItem item = repository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Item não encontrado"));
        repository.delete(item);
    }

}



