package com.progra.matriculaprogra.dominio.entidades;

import jakarta.persistence.*;

@Entity(name = "tbl_estado_orden")
public class EstadoDeOrden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado_orden")
    private long id_estado_orden;
    @Column (name = "nombre")
    private String nombre;

    public long getId_estado_orden() {
        return id_estado_orden;
    }

    public void setId_estado_orden(long id_estado_orden) {
        this.id_estado_orden = id_estado_orden;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
