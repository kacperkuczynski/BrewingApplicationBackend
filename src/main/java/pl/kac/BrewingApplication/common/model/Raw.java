package pl.kac.BrewingApplication.common.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Raw implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String name;
    private String unitMeasure;
    @JsonManagedReference(value="raw-movement")
    @OneToMany(mappedBy = "rawId", cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private List<Ingredient> ingredient;
}
