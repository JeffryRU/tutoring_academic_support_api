package com.upao.tutoring_academic_support_api.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Pay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double monto;
    private LocalDateTime fecha;
    private String metodoPago; // "TARJETA", "PAYPAL", etc.

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User usuario;  // Usa el nombre "usuario" en lugar de "User" para claridad y consistencia

    public Pay() {
    }

    public Pay(Double monto, LocalDateTime fecha, String metodoPago, User usuario) {
        this.monto = monto;
        this.fecha = fecha;
        this.metodoPago = metodoPago;
        this.usuario = usuario; // Usa "usuario" para consistencia con el campo
    }

}