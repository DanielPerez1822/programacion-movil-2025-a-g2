package com.BackPM.BackPM.controllers;

import com.BackPM.BackPM.models.Pedido;
import com.BackPM.BackPM.services.IService.IPedidoService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pedidos")
public class PedidoController extends ABaseController<Pedido, IPedidoService> {

    private IPedidoService pedidoService;

    protected PedidoController(IPedidoService service) {
        super(service, "Pedidos");
        //TODO Auto-generated constructor stub
    }
    
    @GetMapping("/findByProducto/{id}")
    public List<Pedido> findByProductoId(@PathVariable Long id) {
        return pedidoService.findByProductoId(id);
    }
}
