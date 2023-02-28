package pl.kac.BrewingApplication.ingredient.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kac.BrewingApplication.common.model.Ingredient;
import pl.kac.BrewingApplication.common.model.Raw;
import pl.kac.BrewingApplication.ingredient.controller.dto.IngredientDto;
import pl.kac.BrewingApplication.ingredient.repository.IngredientRepository;
import pl.kac.BrewingApplication.raw.repository.RawRepository;
import pl.kac.BrewingApplication.recipe.model.Recipe;
import pl.kac.BrewingApplication.recipe.repository.RecipeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientRepository ingredientRepository;


    public List<Ingredient> getIngredients() {
        return ingredientRepository.findAll();
    }

    public Ingredient getIngredient(Long id) {
        return ingredientRepository.findById(id).orElseThrow();
    }

    public Ingredient createIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public Ingredient updateIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }
}
