package com.BackPM.BackPM.controllers;

import com.BackPM.BackPM.models.Categoria;
import com.BackPM.BackPM.services.IService.ICategoriaService;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
@RequestMapping("/categorias")
public class CategoriaController extends ABaseController<Categoria, ICategoriaService> {
    
    private ICategoriaService categoriaService;

    protected CategoriaController(ICategoriaService service) {
        super(service, "Categoria");
        //TODO Auto-generated constructor stub
    }

    @GetMapping("/nombre/{nombre}")
    public Optional<Categoria> getCategoriaByNombre(@PathVariable String nombre) {
        return categoriaService.getCategoriaByNombre(nombre);
    }
}
