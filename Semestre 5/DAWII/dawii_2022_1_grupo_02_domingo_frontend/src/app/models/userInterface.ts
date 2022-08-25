export interface UserInterface{
    email: string;
    clave: string;
    nombre?: string;
    perfil?: 'cliente'|'marca'|'producto'|'proveedor'|'reclamo'|'sede'|'admin';
    uid?: string,
}