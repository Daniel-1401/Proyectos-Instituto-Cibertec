package com.comartnet.comart.repositoryService;

import java.util.List;
import java.util.Optional;

import com.comartnet.comart.model.Usuario;

public interface IUsuarioService {

	public List<Usuario> listar();	
	public Optional<Usuario>listarId(int id);
	public int guardar(Usuario u);
	public void eliminar(int id);
	
}
