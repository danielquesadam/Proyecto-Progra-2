package com.progra.matriculaprogra.dominio.repositorios;

import com.progra.matriculaprogra.dominio.entidades.EstadoDeOrden;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RepEstadoDeOrden extends CrudRepository<EstadoDeOrden, String> {
    Optional<RepEstadoDeOrden> findBycodigo(String codigo);

}
