package pl.kac.BrewingApplication.user.recipe.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import pl.kac.BrewingApplication.common.model.Ingredient;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numRec;
    private String nameRec;
    private String type;
    private LocalDateTime created;
    private double resultAmount;
    private double resultExtract;

    //WRZENIE
    private int boilTime;

    //WHIRPOOL
    private int timeWhirpool;

    @JsonManagedReference(value="recipe-movement")
    @OneToMany(mappedBy = "recipeId", cascade = {CascadeType.PERSIST})
    private List<Ingredient> ingredients;
}
