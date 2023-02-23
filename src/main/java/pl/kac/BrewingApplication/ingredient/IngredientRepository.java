package pl.kac.BrewingApplication.ingredient;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kac.BrewingApplication.common.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}