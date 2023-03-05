package pl.kac.BrewingApplication.admin.ingredient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kac.BrewingApplication.common.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

}
