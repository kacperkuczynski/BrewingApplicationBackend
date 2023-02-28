package pl.kac.BrewingApplication.ingredient.controller.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pl.kac.BrewingApplication.common.model.Raw;
import pl.kac.BrewingApplication.recipe.model.Recipe;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;

@Getter
@Builder
@Setter
public class IngredientDto {
    @NotNull
    @Min(1)
    @Max(999)
    private Double amount;

    private Raw rawId;

    private Recipe recipeId;
}
