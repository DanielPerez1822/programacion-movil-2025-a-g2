package com.BackPM.BackPM.repositories;

import com.BackPM.BackPM.models.Pedido;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface IPedidoRepository extends IBaseRepository<Pedido, Long> {
    // Buscar pedidos que contengan un producto específico
    List<Pedido> findByProductos_Id(Long productoId);
}
