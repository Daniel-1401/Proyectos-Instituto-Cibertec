import { DetallePedido } from './DetallePedido';
import { CabeceraPedido } from './CabecerPedido';
export interface RealizarPedido{
    cabeceraPedido?: CabeceraPedido;
    detallePedido?: DetallePedido[];
}