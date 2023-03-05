package pl.kac.BrewingApplication.admin.raw.controller.dto;

import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
public class RawDto {
    @NotBlank
    @Length(min = 4)
    private String type;
    @NotBlank
    @Length(min = 4)
    private String name;
    @NotBlank
    @Length(min = 2)
    private String unitMeasure;
}
