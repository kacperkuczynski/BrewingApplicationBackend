package pl.kac.BrewingApplication.raw.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kac.BrewingApplication.common.model.Raw;
import pl.kac.BrewingApplication.raw.repository.RawRepository;

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
    public Raw createRaw(Raw raw) {
        return rawRepository.save(raw);
    }

    public Raw updateRaw(Raw raw) {
        return rawRepository.save(raw);
    }

    public void deleteRaw(Long id) {
        rawRepository.deleteById(id);
    }
}
