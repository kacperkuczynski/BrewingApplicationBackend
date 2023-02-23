package pl.kac.BrewingApplication.ingredient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kac.BrewingApplication.common.model.Ingredient;

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
}
