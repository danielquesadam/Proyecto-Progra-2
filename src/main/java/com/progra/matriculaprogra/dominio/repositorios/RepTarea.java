package com.progra.matriculaprogra.dominio.repositorios;

import com.progra.matriculaprogra.dominio.entidades.Tarea;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RepTarea extends CrudRepository<Tarea, Long> {
    Optional<Tarea> findBynombre(String nombre);

}
