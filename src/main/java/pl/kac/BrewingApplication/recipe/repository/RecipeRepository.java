package pl.kac.BrewingApplication.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kac.BrewingApplication.recipe.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
