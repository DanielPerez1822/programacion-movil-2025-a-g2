package com.BackPM.BackPM.models;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "detalle_factura")
public class Detalle_Factura extends ABaseEntity {

    @ManyToOne(fetch = FetchType.EAGER) // Optimización de rendimiento con carga perezosa
    @JoinColumn(name = "id_factura", nullable = false, referencedColumnName = "id")
    private Factura factura;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "precio_unitario", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioUnitario;

    @Column(name = "subtotal", nullable = false, precision = 12, scale = 2)
    private BigDecimal subtotal;

    // Getters y Setters
    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
        calcularSubtotal();
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
        calcularSubtotal();
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    // Método para calcular el subtotal
    public void calcularSubtotal() {
        if (this.cantidad != null && this.precioUnitario != null) {
            this.subtotal = this.precioUnitario.multiply(BigDecimal.valueOf(this.cantidad));
        } else {
            this.subtotal = BigDecimal.ZERO;
        }
    }
}
