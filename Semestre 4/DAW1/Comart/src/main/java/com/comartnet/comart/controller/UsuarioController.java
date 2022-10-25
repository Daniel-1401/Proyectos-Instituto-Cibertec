package com.comartnet.comart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.comartnet.comart.model.Usuario;
import com.comartnet.comart.repositoryService.IUsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private IUsuarioService service;
	
	@GetMapping("/listarUsuarios")
	public String listarprod(Model model) {
		List<Usuario> usuarios =  service.listar();
		model.addAttribute("lstUsuarios", usuarios);
		return "tables-usuarios";
	}
	
	@GetMapping("/nuevoUsuario")
	public String nuevoProd(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "registro-usuarios";
	}
	
	@PostMapping("/insertarUsuario")
	public String insertarProd(@Validated Usuario u, Model model ) {
		service.guardar(u);
		return "redirect:/listarUsuarios";
	}

}
