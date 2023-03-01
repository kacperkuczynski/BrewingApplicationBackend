package pl.kac.BrewingApplication.ingredient.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import pl.kac.BrewingApplication.common.model.Raw;
import pl.kac.BrewingApplication.recipe.model.Recipe;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
@Getter
public class IngredientDto {
    private Long id;
    @NotNull
    @Min(1)
    @Max(999)
    private Double amount;
    private Raw rawId;
    private Recipe recipeId;
}
