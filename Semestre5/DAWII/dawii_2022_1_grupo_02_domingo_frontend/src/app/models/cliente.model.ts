import { Ubigeo } from "./ubigeo.model";

export class Cliente {
    idCliente?:number;
    nombres ?: string; 
    apellidos ?: string;
    fechaNacimiento?: Date;
    dni ?: string;
    correo ?: string; 
    fechaRegistro ?: Date; 
    direccion ?: string; 
    estado ?: number; 
    ubigeo ?: Ubigeo;
}
 