package interfaces;

import beans.usuarioDTO;

public interface usuarioDAO {

	
	public int registrar(usuarioDTO u);
	public usuarioDTO validar(String usuario , String clave);
}
