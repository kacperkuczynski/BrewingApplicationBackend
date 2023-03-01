package pl.kac.BrewingApplication.recipe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.kac.BrewingApplication.recipe.controller.dto.RecipeDto;
import pl.kac.BrewingApplication.recipe.controller.dto.RecipeIngredientDto;
import pl.kac.BrewingApplication.recipe.model.Recipe;
import pl.kac.BrewingApplication.recipe.service.RecipeService;

import java.util.List;

import static java.time.LocalDateTime.now;

@RestController
@RequestMapping("/recipes")
@RequiredArgsConstructor
public class RecipeController {

    public static final Long EMPTY_ID = null;
    private final RecipeService recipeService;

    @GetMapping
    public List<Recipe> getRecipes(){
        return recipeService.getRecipes();
    }


    @GetMapping("/Q")
    public List<RecipeIngredientDto> getRecipeAndIngredients(){
        return recipeService.getRecipeAndIngredients();
    }

    @GetMapping("/{id}")
    public Recipe getRecipe(@PathVariable Long id){
        return recipeService.getRecipe(id);
    }

    @PostMapping
    public Recipe createRecipe(@RequestBody RecipeDto recipeDto){
        return recipeService.createRecipe(mapToRecipe(recipeDto, EMPTY_ID));
    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@PathVariable Long id, @RequestBody RecipeDto recipeDto){
        return recipeService.updateRecipe(mapToRecipe(recipeDto, id));
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable Long id){
        recipeService.deleteRecipe(id);
    }

    private Recipe mapToRecipe(RecipeDto recipeDto, Long id) {
        return Recipe.builder()
                .id(id)
                .numRec(recipeDto.getNumRec())
                .nameRec(recipeDto.getNameRec())
                .type(recipeDto.getType())
                .created(now())
                .resultAmount(recipeDto.getResultAmount())
                .resultExtract(recipeDto.getResultExtract())
                .boilTime(recipeDto.getBoilTime())
                .timeWhirpool(recipeDto.getTimeWhirpool())
                .build();
    }

}
