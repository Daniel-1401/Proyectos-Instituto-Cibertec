package com.comartnet.comart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comartnet.comart.model.Usuario;
import com.comartnet.comart.repository.IUsuarioRepository;
import com.comartnet.comart.repositoryService.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService{

	@Autowired
	private IUsuarioRepository data;
	
	@Override
	public List<Usuario> listar() {
		return (List<Usuario>) data.findAll();
	}

	@Override
	public Optional<Usuario> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public int guardar(Usuario u) {
		int res = 0;
		Usuario user = data.save(u);
		
		if(!user.equals(null)) {
			res = 1;
		}
		return res;
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}
}
