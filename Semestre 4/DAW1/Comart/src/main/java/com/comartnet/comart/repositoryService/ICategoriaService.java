package com.comartnet.comart.repositoryService;

import java.util.List;
import java.util.Optional;

import com.comartnet.comart.model.Categoria;

public interface ICategoriaService {

	public List<Categoria> listar();	
	public Optional<Categoria>listarId(int id);
	public int guardar(Categoria c);
	public void eliminar(int id);
	
}
