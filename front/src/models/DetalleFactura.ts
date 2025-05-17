import { Factura } from "./Factura";
import { Producto } from "./Producto";

export class DetalleFactura {
  id: number;
  facturaId: Factura;
  cantidad: number;
  precioUnitario: number;
  subtotal: number;
  productoNombre?: string; // <-- Agregado para mostrar el nombre del producto

  constructor(
    id: number,
    facturaId: Factura,
    cantidad: number,
    precioUnitario: number,
    subtotal: number,
    productoNombre?: string // <-- Agregado
  ) {
    this.id = id;
    this.facturaId = facturaId;
    this.cantidad = cantidad;
    this.precioUnitario = precioUnitario;
    this.subtotal = subtotal;
    this.productoNombre = productoNombre; // <-- Agregado
  }
}
