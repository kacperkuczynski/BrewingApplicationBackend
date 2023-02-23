package pl.kac.BrewingApplication.raw;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.kac.BrewingApplication.common.model.Raw;

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

//    @PostMapping
//    public Raw createCategory(@RequestBody RawDto rawDto){
//        return rawService.createCategory(mapToRaw(rawDto, EMPTY_ID ));
//    }
}
