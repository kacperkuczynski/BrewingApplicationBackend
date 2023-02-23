package pl.kac.BrewingApplication.common.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.kac.BrewingApplication.common.model.Ingredient;

import javax.persistence.*;
import java.util.List;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Raw {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String name;
    private String unitMeasure;
    @JsonManagedReference
    @OneToMany(mappedBy = "rawId", cascade = {CascadeType.ALL})
    private List<Ingredient> ingredients;
}
