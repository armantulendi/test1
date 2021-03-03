package com.example.securedemo.rest;
import com.example.securedemo.model.Sotrudnik;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/sotrudniki")
public class SotrudnikiRestControllerV1 {
    private List<Sotrudnik> SOTRUDNIKI = Stream.of(

            new Sotrudnik(1L,"Petr","Petrov"),
            new Sotrudnik(  2L,"Ivan","Ivanov"),
            new Sotrudnik(3L,"Sergei","Sidorov")
    ).collect(Collectors.toList());


    @GetMapping
    public List<Sotrudnik>getAll(){
        return SOTRUDNIKI;
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('sotrudniki:read')")
    public Sotrudnik getById(@PathVariable Long id){
        return SOTRUDNIKI.stream().filter(sotrudnik -> sotrudnik.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    @PostMapping
    @PreAuthorize("hasAuthority('sotrudniki:write')")
    public Sotrudnik create(@RequestBody Sotrudnik sotrudnik){
        this.SOTRUDNIKI.add(sotrudnik);
        return sotrudnik;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('sotrudniki:write')")
    public void deleteById(@PathVariable Long id){
        this.SOTRUDNIKI.removeIf(sotrudnik -> sotrudnik.getId().equals(id));
    }
}
