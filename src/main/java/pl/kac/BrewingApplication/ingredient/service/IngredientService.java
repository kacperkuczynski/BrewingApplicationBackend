package pl.kac.BrewingApplication.ingredient.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kac.BrewingApplication.common.model.Ingredient;
import pl.kac.BrewingApplication.ingredient.controller.dto.IngredientDto;
import pl.kac.BrewingApplication.ingredient.controller.dto.IngredientRawDto;
import pl.kac.BrewingApplication.ingredient.repository.IngredientRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientRepository ingredientRepository;


    public List<IngredientRawDto> getIngredientRaw() {
        return ingredientRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }


    private IngredientRawDto convertEntityToDto(Ingredient ingredient){
        IngredientRawDto ingredientRawDto = IngredientRawDto.builder()
                .amount(ingredient.getAmount())
                .typeRaw(ingredient.getRawId().getType())
                .name(ingredient.getRawId().getName())
                .unitMeasure(ingredient.getRawId().getUnitMeasure())
                .build();
        return ingredientRawDto;

    }


    public Ingredient getIngredient(Long id) {
        return ingredientRepository.findById(id).orElseThrow();
    }

    public Ingredient createIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public Ingredient updateIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

}
