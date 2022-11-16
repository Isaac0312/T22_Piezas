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
import com.example.demo.dto.Piezas;
import com.example.demo.service.PiezasServiceImpl;

@RestController
@RequestMapping("/api")
public class PiezasController {
	
	@Autowired
	PiezasServiceImpl piezasServiceImpl;
	
	@GetMapping("/piezas")
	public List<Piezas> listarPiezas(){
		return piezasServiceImpl.listarPiezas();
	}
	
	@PostMapping("/piezas")
	public Piezas salvarPieza(@RequestBody Piezas pieza) {
		return piezasServiceImpl.guardarPieza(pieza);
	}
	
	@GetMapping("/piezas/{id}")
	public Piezas piezaXId(@PathVariable(name="id")int id) {
		
		Piezas pieza_x_id = new Piezas();
		pieza_x_id = piezasServiceImpl.piezaXId(id);
		System.out.println("Pieza XID: "+pieza_x_id);
		return pieza_x_id;
	}
	
	@PutMapping("/piezas/{id}")
	public Piezas actualizarPieza(@PathVariable(name="id")int id,@RequestBody Piezas pieza) {
		
		Piezas pieza_seleccionado= new Piezas();
		Piezas pieza_actualizado= new Piezas();
		
		pieza_seleccionado= piezasServiceImpl.piezaXId(id);
		
		pieza_seleccionado.setNombre(pieza.getNombre());
		
		pieza_actualizado = piezasServiceImpl.actualizarPieza(pieza_seleccionado);
		
		System.out.println("La pieza actualizada es: "+ pieza_actualizado);
		
		return pieza_actualizado;
	}
	
	@DeleteMapping("/piezas/{id}")
	public void eliminarPieza(@PathVariable(name="id")int id) {
		piezasServiceImpl.eliminarPieza(id);
	}

}
