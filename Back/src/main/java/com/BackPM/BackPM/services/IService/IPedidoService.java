package com.BackPM.BackPM.services.IService;

import com.BackPM.BackPM.models.Pedido;

import java.util.List;

public interface IPedidoService extends IBaseService<Pedido> {
    List<Pedido> findByProductoId(Long productoId);
}
