package pl.kac.BrewingApplication.admin.ingredient.controller.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
@Getter
public class IngredientRawDto {

    //Ingredient
    @NotNull
    @Min(1)
    @Max(999)
    private Double amount;

    //Raw
    @NotBlank
    @Length(min = 4)
    private String typeRaw;
    @NotBlank
    @Length(min = 4)
    private String name;
    @NotBlank
    @Length(min = 2)
    private String unitMeasure;
}
