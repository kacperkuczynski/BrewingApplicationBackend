package pl.kac.BrewingApplication.raw;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kac.BrewingApplication.common.model.Raw;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RawService {

    private final RawRepository rawRepository;
    public List<Raw> getRaws() {
        return rawRepository.findAll();
    }

    public Raw getRaw(Long id) {
        return rawRepository.findById(id).orElseThrow();
    }
}
