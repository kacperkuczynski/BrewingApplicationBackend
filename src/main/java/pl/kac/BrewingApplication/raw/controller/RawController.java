package pl.kac.BrewingApplication.raw.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.kac.BrewingApplication.common.model.Raw;
import pl.kac.BrewingApplication.raw.controller.dto.RawDto;
import pl.kac.BrewingApplication.raw.service.RawService;

import java.util.List;

@RestController
@RequestMapping("/raws")
@RequiredArgsConstructor
public class RawController {

    public static final Long EMPTY_ID = null;

    private final RawService rawService;

    @GetMapping()
    public List<Raw> getRaws(){return rawService.getRaws();}

    @GetMapping("/{id}")
    public Raw getRaw(@PathVariable Long id){return rawService.getRaw(id);}

    @PostMapping
    public Raw createRaw(@RequestBody RawDto rawDto){
        return rawService.createRaw(mapToRaw(rawDto, EMPTY_ID ));
    }

    @PutMapping("/{id}")
    public Raw updateRaw(@PathVariable Long id, @RequestBody RawDto rawDto){
        return rawService.updateRaw(mapToRaw(rawDto, id));
    }

    @DeleteMapping("/{id}")
    public void deleteRaw(@PathVariable Long id){
        rawService.deleteRaw(id);
    }

    private Raw mapToRaw(RawDto rawDto, Long id) {
        return Raw.builder()
                .id(id)
                .type(rawDto.getType())
                .name(rawDto.getName())
                .unitMeasure(rawDto.getUnitMeasure())
                .build();
    }
}
