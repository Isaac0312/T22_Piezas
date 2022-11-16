package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.Proveedores;
import com.example.demo.service.ProveedoresServiceImpl;

@RestController
@RequestMapping("/api")
public class ProveedoresController {
	
	@Autowired
	ProveedoresServiceImpl proveedoresServiceImpl;
	
	@GetMapping("/proveedores")
	public List<Proveedores> listarProveedores(){
		return proveedoresServiceImpl.listarProveedores();
	}
	
	@PostMapping("/proveedores")
	public Proveedores salvarProveedor(@RequestBody Proveedores proveedor) {
		return proveedoresServiceImpl.guardarProveedor(proveedor);
	}
	
	@GetMapping("/proveedores/{id}")
	public Proveedores proveedorXId(@PathVariable(name="id")int id) {
		
		Proveedores proveedor_x_id = new Proveedores();
		proveedor_x_id = proveedoresServiceImpl.proveedorXId(id);
		System.out.println("Proveedor XID: "+proveedor_x_id);
		return proveedor_x_id;
	}
	
	@PutMapping("/proveedores/{id}")
	public Proveedores actualizarProveedor(@PathVariable(name="id")int id,@RequestBody Proveedores proveedor) {
		
		Proveedores proveedor_seleccionado= new Proveedores();
		Proveedores proveedor_actualizado= new Proveedores();
		
		proveedor_seleccionado= proveedoresServiceImpl.proveedorXId(id);
		
		proveedor_seleccionado.setNombre(proveedor.getNombre());
		
		proveedor_actualizado = proveedoresServiceImpl.actualizarProveedor(proveedor_seleccionado);
		
		System.out.println("El proveedor actualizado es: "+ proveedor_actualizado);
		
		return proveedor_actualizado;
	}
	
	@DeleteMapping("/proveedores/{id}")
	public void eliminarProveedor(@PathVariable(name="id")int id) {
		proveedoresServiceImpl.eliminarProveedor(id);
	}

}