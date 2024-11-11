package com.progra.matriculaprogra.controladores;

import com.progra.matriculaprogra.dominio.dto.DTOTarea;
import com.progra.matriculaprogra.dominio.entidades.Tarea;
import com.progra.matriculaprogra.dominio.repositorios.RepTarea;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("curso")
@CrossOrigin(origins = "*")
public class TareaController {
    private final RepTarea RepTarea;

    public TareaController(RepTarea rep) {
        this.RepTarea = rep;
    }

    @GetMapping
    public @ResponseBody Iterable<Tarea> Listar() {
        return this.RepTarea.findAll();
    }

    @GetMapping("{id}")
    public @ResponseBody Optional<Tarea> Consultar(@PathVariable("id") Long idTarea) {
        return this.RepTarea.findById(idTarea);
    }

    @GetMapping("codigo/{id}")
    public @ResponseBody Optional<Tarea> ConsultarCodigo(@PathVariable("id") String nombre) {
        return this.RepTarea.findBynombre(nombre);
    }

    @PostMapping
    public @ResponseBody boolean Guardar(@RequestBody Tarea tarea) {
        RepTarea.save(tarea);
        return true;
    }

    @PutMapping
    public @ResponseBody boolean Actualizar(@RequestBody Tarea tarea) {
        Tarea consulta = this.RepTarea.findById(tarea.getIdTarea()).orElse(null);
        if (consulta != null && consulta.getIdTarea() > 0) {
            RepTarea.save(tarea);
            return true;
        }
        return false;
    }

    @PatchMapping
    public @ResponseBody boolean Estado(@RequestBody DTOTarea Tarea) {
        Tarea obTarea = this.RepTarea.findById(Tarea.idTarea()).orElse(null);
        if (obTarea != null && obTarea.getIdTarea() > 0) {
            obTarea.setEstado(Tarea.estado());
            RepTarea.save(obTarea);
            return true;
        }
        return false;
    }
}
