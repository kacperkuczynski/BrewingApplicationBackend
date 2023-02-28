package pl.kac.BrewingApplication.recipe.controller.dto;

import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Builder
public class RecipeDto {
    @NotNull
    @Min(0)
    private int numRec;
    @NotBlank
    @Length(min = 4)
    private String nameRec;
    @NotBlank
    @Length(min = 4)
    private String type;
    @NotNull
    private LocalDateTime created;
    @NotNull
    @Min(0)
    @Max(1500)
    private double resultAmount;
    @NotNull
    @Min(0)
    @Max(40)
    private double resultExtract;

    //WRZENIE
    @NotNull
    @Min(0)
    @Max(100)
    private int boilTime;

    //WHIRPOOL
    @NotNull
    @Min(0)
    @Max(100)
    private int timeWhirpool;
}
