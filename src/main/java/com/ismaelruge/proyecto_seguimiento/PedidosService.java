package com.ismaelruge.proyecto_seguimiento;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service // Indica que esta clase es un servicio de Spring
public class PedidosService {

    private final List<Pedido> pedidos = new ArrayList<>(); // Lista en memoria para almacenar pedidos
    private final AtomicInteger contadorId = new AtomicInteger(1); // Generador de ID automático

    // Listar todos los pedidos
    public Flux<Pedido> listarPedidos() {
        return Flux.fromIterable(pedidos); // Retorna un flujo de pedidos (reactivo)
    }

    // Buscar pedido por ID
    public Mono<Pedido> obtenerPedidoPorId(int id) {
        return Mono.justOrEmpty(pedidos.stream() // Busca en la lista de pedidos
                .filter(pedido -> pedido.getIdPedido() == id) // Filtra por ID
                .findFirst()); // Devuelve el primer pedido encontrado (o vacío si no existe)
    }

    // Guardar un nuevo pedido
    public Mono<Pedido> crearPedido(Pedido pedido) {
        pedido.setIdPedido(contadorId.getAndIncrement()); // Asigna un ID único autoincremental
        pedido.setFecha(LocalDateTime.now()); // Asigna la fecha y hora actual
        pedidos.add(pedido); // Agrega el pedido a la lista
        return Mono.just(pedido); // Retorna el pedido creado de forma reactiva
    }

    // Actualizar un pedido existente
    public Mono<Pedido> actualizarPedido(int id, Pedido pedidoActualizado) {
        Optional<Pedido> pedidoExistente = pedidos.stream() // Busca el pedido en la lista
                .filter(p -> p.getIdPedido() == id)
                .findFirst();

        if (pedidoExistente.isPresent()) { // Si el pedido existe, actualiza los valores
            Pedido pedido = pedidoExistente.get();
            pedido.setCliente(pedidoActualizado.getCliente());
            pedido.setTotal(pedidoActualizado.getTotal());
            pedido.setEstado(pedidoActualizado.getEstado());
            return Mono.just(pedido); // Retorna el pedido actualizado
        } else {
            return Mono.empty(); // Retorna vacío si el pedido no existe
        }
    }

    // Eliminar un pedido por ID
    public Mono<Void> eliminarPedido(int id) {
        pedidos.removeIf(pedido -> pedido.getIdPedido() == id); // Elimina el pedido de la lista
        return Mono.empty(); // Retorna un Mono vacío (indicando éxito)
    }
}
