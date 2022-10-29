package com.comartnet.comart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.comartnet.comart.model.Categoria;
import com.comartnet.comart.repositoryService.ICategoriaService;

@Controller
public class CategoriaController {
	
	@Autowired
	private ICategoriaService service;
	
	@GetMapping("/listarCategorias")
	public String listarprod(Model model) {
		List<Categoria> categorias =  service.listar();
		model.addAttribute("lstCategorias", categorias);
		return "tables-categorias";
	}

}
