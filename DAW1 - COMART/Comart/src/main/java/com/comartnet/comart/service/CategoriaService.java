package com.comartnet.comart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comartnet.comart.model.Categoria;
import com.comartnet.comart.repository.ICategoriaRepository;
import com.comartnet.comart.repositoryService.ICategoriaService;

@Service
public class CategoriaService implements ICategoriaService{

	@Autowired
	private ICategoriaRepository data;
	
	@Override
	public List<Categoria> listar() {
		return (List<Categoria>) data.findAll();
	}

	@Override
	public Optional<Categoria> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public int guardar(Categoria c) {
		int res = 0;
		Categoria category = data.save(c);
		
		if(!category.equals(null)) {
			res = 1;
		}
		return res;
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}
}
