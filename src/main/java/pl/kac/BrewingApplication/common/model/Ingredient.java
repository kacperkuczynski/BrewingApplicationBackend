package pl.kac.BrewingApplication.common.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import pl.kac.BrewingApplication.recipe.model.Recipe;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    @JsonBackReference(value="raw-movement")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "raw_id")
    private Raw rawId;
    @JsonBackReference(value="recipe-movement")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id")
    private Recipe recipeId;


}
