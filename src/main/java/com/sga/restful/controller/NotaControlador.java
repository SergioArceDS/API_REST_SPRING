package com.sga.restful.controller;

import com.sga.restful.entity.Nota;
import com.sga.restful.model.MNota;
import com.sga.restful.service.NotaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class NotaControlador {

    @Autowired
    @Qualifier("servicio")
    NotaServicio servicio;

    @PutMapping("/nota")
    public boolean agregarNota(@RequestBody @Validated Nota nota) {
        return servicio.crear(nota);
    }

    @PostMapping ("/nota")
    public boolean actualizarNota(@RequestBody @Validated Nota nota) {
        return servicio.actualizar(nota);
    }

    @DeleteMapping("/nota/{id}/{nombre}")
    public boolean borrarNota(
            @PathVariable("id") long id,
            @PathVariable("nombre") String nombre) {

        return servicio.borrar(nombre, id);
    }

    @GetMapping("/notas")
    public List<MNota> obtenerNotas(Pageable pageable){

        return servicio.obtenerPorPaginacion(pageable);
    }
}
