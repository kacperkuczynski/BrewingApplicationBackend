package pl.kac.BrewingApplication.raw;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kac.BrewingApplication.common.model.Raw;

public interface RawRepository extends JpaRepository<Raw,Long> {
}
