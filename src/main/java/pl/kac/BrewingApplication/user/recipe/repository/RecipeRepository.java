package pl.kac.BrewingApplication.user.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kac.BrewingApplication.user.recipe.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    
}
