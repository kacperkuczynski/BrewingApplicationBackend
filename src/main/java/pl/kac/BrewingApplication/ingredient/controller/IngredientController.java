package pl.kac.BrewingApplication.ingredient.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.kac.BrewingApplication.common.model.Ingredient;
import pl.kac.BrewingApplication.common.model.Raw;
import pl.kac.BrewingApplication.ingredient.controller.dto.IngredientDto;
import pl.kac.BrewingApplication.ingredient.service.IngredientService;
import pl.kac.BrewingApplication.raw.repository.RawRepository;
import pl.kac.BrewingApplication.recipe.model.Recipe;
import pl.kac.BrewingApplication.recipe.repository.RecipeRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ingredients")
@RequiredArgsConstructor
public class IngredientController {

    public static final Long EMPTY_ID = null;

    private final IngredientService ingredientService;
    private final RecipeRepository recipeRepository;
    private final RawRepository rawRepository;

    @GetMapping()
    public List<Ingredient> getIngredients(){return ingredientService.getIngredients();}

    @GetMapping("/{id}")
    public Ingredient getIngredient(@PathVariable Long id){return ingredientService.getIngredient(id);}

    @PostMapping("/{recipeId}/{rawId}")
    public Ingredient createIngredient(@PathVariable("recipeId") Long recipeId,
                                       @PathVariable("rawId") Long rawId,
                                       @Valid @RequestBody IngredientDto ingredientDto){
        return ingredientService.createIngredient(mapToIngredient(ingredientDto, recipeId, rawId, EMPTY_ID));
    }

    @PutMapping("/{id}/{recipeId}/{rawId}")
    public Ingredient updateIngredient(@PathVariable("id") Long id,
                                       @PathVariable("recipeId") Long recipeId,
                                       @PathVariable("rawId") Long rawId,
                                       @Valid @RequestBody IngredientDto ingredientDto) {
        return ingredientService.updateIngredient(mapToIngredient(ingredientDto, id, recipeId, rawId));
    }

    private Ingredient mapToIngredient(IngredientDto ingredientDto, Long id, Long recipeId, Long rawId) {
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow();
        Raw raw = rawRepository.findById(rawId).orElseThrow();
        return Ingredient.builder()
                .id(id)
                .amount(ingredientDto.getAmount())
                .recipeId(recipe)
                .rawId(raw)
                .build();
    }


}
