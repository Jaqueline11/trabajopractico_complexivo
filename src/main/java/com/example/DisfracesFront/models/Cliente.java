package com.example.DisfracesFront.models;

import jakarta.validation.constraints.NotEmpty;

public class Cliente {


    private Long id_cliente;
    @NotEmpty
    private String cedula;
    @NotEmpty
    private String nombres_cliente;
    @NotEmpty
    private String apellidos_cliente;
    @NotEmpty
    private String direccion_cliente;

    private Boolean estado_cliente;

    public Long getId_cliente() {
        return id_cliente;
    }

    public Cliente(Long id_cliente, String cedula, String nombres_cliente, String apellidos_cliente, String direccion_cliente, Boolean estado_cliente) {
        super();
        this.id_cliente = id_cliente;
        this.cedula = cedula;
        this.nombres_cliente = nombres_cliente;
        this.apellidos_cliente = apellidos_cliente;
        this.direccion_cliente = direccion_cliente;
        this.estado_cliente = estado_cliente;
    }

    public Cliente() {

    }


    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres_cliente() {
        return nombres_cliente;
    }

    public void setNombres_cliente(String nombres_cliente) {
        this.nombres_cliente = nombres_cliente;
    }

    public String getApellidos_cliente() {
        return apellidos_cliente;
    }

    public void setApellidos_cliente(String apellidos_cliente) {
        this.apellidos_cliente = apellidos_cliente;
    }

    public String getDireccion_cliente() {
        return direccion_cliente;
    }

    public void setDireccion_cliente(String direccion_cliente) {
        this.direccion_cliente = direccion_cliente;
    }

    public Boolean getEstado_cliente() {
        return estado_cliente;
    }

    public void setEstado_cliente(Boolean estado_cliente) {
        this.estado_cliente = estado_cliente;
    }
}
