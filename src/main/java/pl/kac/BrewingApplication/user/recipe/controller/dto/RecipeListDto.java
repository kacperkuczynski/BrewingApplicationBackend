package pl.kac.BrewingApplication.user.recipe.controller.dto;

import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Builder
@Getter
public class RecipeListDto {
    private Long id;
    private int numRec;
    private String nameRec;
    private String type;
    private LocalDateTime created;
    private double resultAmount;
    private double resultExtract;
}
