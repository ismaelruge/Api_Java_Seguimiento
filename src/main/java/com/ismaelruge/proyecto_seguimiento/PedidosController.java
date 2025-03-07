package com.ismaelruge.proyecto_seguimiento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController // Indica que esta clase es un controlador REST
@RequestMapping("/api/pedidos") // Define el prefijo de la URL para todas las rutas de este controlador
public class PedidosController {

    @Autowired // Inyección del servicio de pedidos
    private PedidosService pedidoService;

    // Obtener todos los pedidos
    @GetMapping
    public Flux<Pedido> obtenerTodosLosPedidos() {
        return pedidoService.listarPedidos(); // Retorna un flujo reactivo con todos los pedidos
    }

    // Obtener un pedido por ID
    @GetMapping("/{id}")
    public Mono<Pedido> obtenerPedidoPorId(@PathVariable int id) {
        return pedidoService.obtenerPedidoPorId(id); // Retorna el pedido si existe, o vacío si no
    }

    // Crear un nuevo pedido
    @PostMapping
    public Mono<Pedido> crearPedido(@RequestBody Pedido pedido) {
        return pedidoService.crearPedido(pedido); // Guarda y retorna el pedido creado
    }

    // Actualizar un pedido por ID
    @PutMapping("/{id}")
    public Mono<Pedido> actualizarPedido(@PathVariable int id, @RequestBody Pedido pedido) {
        return pedidoService.actualizarPedido(id, pedido); // Actualiza el pedido si existe
    }

    // Eliminar un pedido por ID
    @DeleteMapping("/{id}")
    public Mono<Void> eliminarPedido(@PathVariable int id) {
        return pedidoService.eliminarPedido(id); // Elimina el pedido si existe
    }
}
