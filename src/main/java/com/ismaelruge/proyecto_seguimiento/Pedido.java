package com.ismaelruge.proyecto_seguimiento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data // Genera automáticamente los métodos getter, setter, toString, equals y hashCode
@AllArgsConstructor // Genera un constructor con todos los atributos
@NoArgsConstructor // Genera un constructor vacío (sin parámetros)
public class Pedido {
    private int idPedido; // Identificador único del pedido
    private LocalDateTime fecha; // Fecha y hora en que se realizó el pedido
    private String cliente; // Nombre o identificador del cliente
    private double total; // Monto total del pedido
    private String estado; // Estado del pedido (Ej: "Pendiente", "Completado", "Cancelado")
}