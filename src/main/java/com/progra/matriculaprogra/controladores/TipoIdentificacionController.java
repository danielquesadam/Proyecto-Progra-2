package com.progra.matriculaprogra.controladores;

import com.progra.matriculaprogra.dominio.entidades.TipoIdentificacion;
import com.progra.matriculaprogra.dominio.repositorios.RepTipoIdentificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("tipo-identificacion")
@CrossOrigin(origins = "*")
public class TipoIdentificacionController {

    private final RepTipoIdentificacion repositorio;

    public TipoIdentificacionController(RepTipoIdentificacion repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping
    public @ResponseBody Iterable<TipoIdentificacion> Listar() {
        return repositorio.findAll();
    }

    @GetMapping("{id}")
    public @ResponseBody Optional<TipoIdentificacion> buscarPorId(@PathVariable("id") Long id) {
        return repositorio.findById(id);
    }

    @PostMapping
    public @ResponseBody boolean Guardar(@RequestBody TipoIdentificacion tipo) {
        repositorio.save(tipo);
        return true;
    }


    @PutMapping
    public @ResponseBody boolean Actualizar(@RequestBody TipoIdentificacion tipo) {
        TipoIdentificacion registro = repositorio.findById(tipo.getIdTipoIdentificacion()).orElse(null);
        if (registro != null && registro.getIdTipoIdentificacion() > 0) {
            repositorio.save(tipo);
            return true;
        }
        return false;
    }

    @DeleteMapping("{id}")
    public @ResponseBody boolean Eliminar(@PathVariable("id") long id) {
        repositorio.deleteById(id);
        return true;
    }
}
