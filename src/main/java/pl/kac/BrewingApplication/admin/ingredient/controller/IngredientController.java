package pl.kac.BrewingApplication.admin.ingredient.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.kac.BrewingApplication.common.model.Ingredient;
import pl.kac.BrewingApplication.common.model.Raw;
import pl.kac.BrewingApplication.admin.ingredient.controller.dto.IngredientDto;
import pl.kac.BrewingApplication.admin.ingredient.controller.dto.IngredientRawDto;
import pl.kac.BrewingApplication.admin.ingredient.service.IngredientService;
import pl.kac.BrewingApplication.admin.raw.repository.RawRepository;
import pl.kac.BrewingApplication.user.recipe.model.Recipe;
import pl.kac.BrewingApplication.user.recipe.repository.RecipeRepository;

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
    public List<IngredientRawDto> getIngredientRaw(){return ingredientService.getIngredientRaw();}


    @PostMapping("/{recipeId}/{rawId}")
    public Ingredient createIngredient(@PathVariable("recipeId") Long recipeId,
                                       @PathVariable("rawId") Long rawId,
                                       @Valid @RequestBody IngredientDto ingredientDto){
        return ingredientService.createIngredient(mapToIngredient(ingredientDto, recipeId, rawId, EMPTY_ID));
    }

    @PutMapping("/{recipeId}/{rawId}/{id}")
    public Ingredient updateIngredient(@PathVariable("recipeId") Long recipeId,
                                       @PathVariable("rawId") Long rawId,
                                       @PathVariable("id") Long id,
                                       @Valid @RequestBody IngredientDto ingredientDto) {
        return ingredientService.updateIngredient(mapToIngredient(ingredientDto, recipeId, rawId, id));
    }

    private Ingredient mapToIngredient(IngredientDto ingredientDto, Long recipeId, Long rawId, Long id) {
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
