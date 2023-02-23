package pl.kac.BrewingApplication.ingredient;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kac.BrewingApplication.common.model.Ingredient;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
@RequiredArgsConstructor
public class IngredientController {

    public static final Long EMPTY_ID = null;

    private final IngredientService ingredientService;

    @GetMapping()
    public List<Ingredient> getIngredients(){return ingredientService.getIngredients();}

    @GetMapping("/{id}")
    public Ingredient getIngredient(@PathVariable Long id){return ingredientService.getIngredient(id);}
}
