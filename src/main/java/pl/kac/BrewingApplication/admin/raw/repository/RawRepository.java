package pl.kac.BrewingApplication.admin.raw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kac.BrewingApplication.common.model.Raw;

public interface RawRepository extends JpaRepository<Raw,Long> {
}
