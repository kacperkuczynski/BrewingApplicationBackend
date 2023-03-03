package pl.kac.BrewingApplication.recipe.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.kac.BrewingApplication.common.model.Ingredient;
import pl.kac.BrewingApplication.ingredient.controller.dto.IngredientRawDto;
import pl.kac.BrewingApplication.recipe.controller.dto.RecipeIngredientDto;
import pl.kac.BrewingApplication.recipe.model.Recipe;
import pl.kac.BrewingApplication.recipe.repository.RecipeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;
    public Page<Recipe> getRecipes(Pageable pageable) {
        return recipeRepository.findAll(pageable);
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


    public List<RecipeIngredientDto> getRecipeAndIngredients() {
        return recipeRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    private RecipeIngredientDto convertEntityToDto (Recipe recipe){
        return RecipeIngredientDto.builder()
                .nameRec(recipe.getNameRec())
                .numRec(recipe.getNumRec())
                .type(recipe.getType())
                .created(recipe.getCreated())
                .resultAmount(recipe.getResultAmount())
                .resultExtract(recipe.getResultExtract())
                .boilTime(recipe.getBoilTime())
                .timeWhirpool(recipe.getTimeWhirpool())
                .ingredients(mapIngredients(recipe.getIngredients()))
                .build();
    }

    private List<IngredientRawDto> mapIngredients(List<Ingredient> ingredients) {
        return ingredients.stream()
                .map(RecipeService::convertIngredientEntityToDto)
                .collect(Collectors.toList());
    }

    private static IngredientRawDto convertIngredientEntityToDto(Ingredient ingredient){
        return IngredientRawDto.builder()
                .amount(ingredient.getAmount())
                .typeRaw(ingredient.getRawId().getType())
                .name(ingredient.getRawId().getName())
                .unitMeasure(ingredient.getRawId().getUnitMeasure())
                .build();


    }
}
