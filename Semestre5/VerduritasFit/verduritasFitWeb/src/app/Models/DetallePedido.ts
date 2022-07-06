export interface DetallePedido{
    id_pedido?: string;
    id_platillo?: number;
    cantidad?: number;
    precioVenta?: number;
    importe?: number;
    old_idplatillo?: number;
    new_idplatillo?: number;
}