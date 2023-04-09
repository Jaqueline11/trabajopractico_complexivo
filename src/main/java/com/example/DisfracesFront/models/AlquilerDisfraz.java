package com.example.DisfracesFront.models;

public class AlquilerDisfraz {
    private Long id_alquiler;
    private Cliente cliente;
    private Disfraces disfraces;
    private String fecha_prestamo;
    private String fecha_devolucion;
    private String comentarios_alquiler;
    private double cantidad_disfraces;
    private double total_alquiler;

    public AlquilerDisfraz(Long id_alquiler, Cliente cliente, Disfraces disfraces, String fecha_prestamo, String fecha_devolucion, String comentarios_alquiler, double cantidad_disfraces, double total_alquiler) {
        super();
        this.id_alquiler = id_alquiler;
        this.cliente = cliente;
        this.disfraces = disfraces;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_devolucion = fecha_devolucion;
        this.comentarios_alquiler = comentarios_alquiler;
        this.cantidad_disfraces = cantidad_disfraces;
        this.total_alquiler = total_alquiler;
    }

    public AlquilerDisfraz() {

    }

    public Long getId_alquiler() {
        return id_alquiler;
    }

    public void setId_alquiler(Long id_alquiler) {
        this.id_alquiler = id_alquiler;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Disfraces getDisfraces() {
        return disfraces;
    }

    public void setDisfraces(Disfraces disfraces) {
        this.disfraces = disfraces;
    }

    public String getFecha_prestamo() {
        return fecha_prestamo;
    }

    public void setFecha_prestamo(String fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public String getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(String fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public String getComentarios_alquiler() {
        return comentarios_alquiler;
    }

    public void setComentarios_alquiler(String comentarios_alquiler) {
        this.comentarios_alquiler = comentarios_alquiler;
    }

    public double getCantidad_disfraces() {
        return cantidad_disfraces;
    }

    public void setCantidad_disfraces(double cantidad_disfraces) {
        this.cantidad_disfraces = cantidad_disfraces;
    }

    public double getTotal_alquiler() {
        return total_alquiler;
    }

    public void setTotal_alquiler(double total_alquiler) {
        this.total_alquiler = total_alquiler;
    }
}
