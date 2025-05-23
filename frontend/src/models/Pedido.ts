import { Producto } from "./Producto";

export class Pedido {
  id: number;
  fecha: string;
  estado: boolean;
  productoId: Producto;

  constructor(id: number, fecha: string, estado: boolean, productoId: Producto) {
    this.id = id;
    this.fecha = fecha;
    this.estado = estado;
    this.productoId = productoId;
  }
}
