package pl.kac.BrewingApplication.recipe.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kac.BrewingApplication.recipe.model.Recipe;
import pl.kac.BrewingApplication.recipe.repository.RecipeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;
    public List<Recipe> getRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe getRecipe(Long id) {
        return recipeRepository.findById(id).orElseThrow();
    }

    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public Recipe updateRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public void deleteRecipe(Long id){
        recipeRepository.deleteById(id);
    }
}
