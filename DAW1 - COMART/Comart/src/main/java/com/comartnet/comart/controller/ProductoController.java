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
import com.comartnet.comart.model.Producto;
import com.comartnet.comart.repositoryService.ICategoriaService;
import com.comartnet.comart.repositoryService.IProductoService;

@Controller
//@RequestMapping(path = "/producto")
public class ProductoController {
	
	@Autowired
	private IProductoService serviceProducto;
	
	@Autowired
	private ICategoriaService serviceCategoria;
	
	@GetMapping("/listarProductos")
	public String listarprod(Model model) {
		List<Producto> productos =  serviceProducto.listar();
		model.addAttribute("lstProductos", productos);
		return "tables-productos";
	}
	
	@GetMapping("/nuevoProducto")
	public String nuevoProd(Model model) {
		List<Categoria> categorias = serviceCategoria.listar();
		model.addAttribute("lstCategoria", categorias);
		model.addAttribute("producto", new Producto());
		return "registro-producto";
	}
	@PostMapping("/guardarProducto")
	public String guardrProd(@Validated Producto p, Model model ) {
		serviceProducto.guardar(p);
		return "redirect:/listarProductos";
	}
	
	@GetMapping("/editarProducto/{id}")
	public String editarProd(@PathVariable int id, Model model) {
		Optional<Producto> producto = serviceProducto.listarId(id);
		List<Categoria> categorias = serviceCategoria.listar();
		model.addAttribute("lstCategoria", categorias);
		model.addAttribute("producto", producto);
		return "actualizar-Producto";
	}
	
	@GetMapping("/eliminarProducto/{id}")
	public String eliminarProducto(Model model, @PathVariable int id) {
		System.out.println("ESTOY EN ELIMINAR " + id);
		serviceProducto.eliminar(id);
		return "redirect:/listarProductos";
	}
}
