package pl.kac.BrewingApplication.recipe.controller;

import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pl.kac.BrewingApplication.recipe.controller.dto.RecipeDto;
import pl.kac.BrewingApplication.recipe.controller.dto.RecipeIngredientDto;
import pl.kac.BrewingApplication.recipe.controller.dto.RecipeListDto;
import pl.kac.BrewingApplication.recipe.model.Recipe;
import pl.kac.BrewingApplication.recipe.service.RecipeService;

import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.LocalDateTime.now;

@RestController
@RequestMapping("/recipes")
@RequiredArgsConstructor
public class RecipeController {

    public static final Long EMPTY_ID = null;
    private final RecipeService recipeService;

    @GetMapping()
    public Page<RecipeListDto> getRecipes(Pageable pageable){
        Page<Recipe> recipes = recipeService.getRecipes(pageable);
        List<RecipeListDto> recipeListDtos = recipes.getContent().stream()
                .map(recipe -> RecipeListDto.builder()
                        .id(recipe.getId())
                        .numRec(recipe.getNumRec())
                        .nameRec(recipe.getNameRec())
                        .type(recipe.getType())
                        .created(recipe.getCreated())
                        .resultAmount(recipe.getResultAmount())
                        .resultExtract(recipe.getResultExtract())
                        .build())
                .collect(Collectors.toList());
        return new PageImpl<>(recipeListDtos, pageable, recipes.getTotalElements());
    }

    //konkatencja w zapytaniu: '... where slug=' + slug
    //dopoki nie uzywamy konkatencji spring data chroni nasze zapytanie przed atakami sql injection
//    @GetMapping("products/{slug}")
//    public RecipeDto getRecipeBySlug(
//            @PathVariable
//            @Pattern(regexp = "[a-z0-9\\-]+")
//            @Length(max = 255)
//            String slug){
//        return recipeService.getProductBySlug(slug);//uzytkownik moze wykonac atak sql injection
//        // czyli atak zlosliwego kodu na bazie danych dlatego
//    }


//    @GetMapping()
//    public List<RecipeIngredientDto> getRecipeAndIngredients(){
//        return recipeService.getRecipeAndIngredients();
//    }

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
