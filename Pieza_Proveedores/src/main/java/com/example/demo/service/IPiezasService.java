package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Piezas;

public interface IPiezasService {
	
	public List<Piezas> listarPiezas();
	
	public Piezas guardarPieza(Piezas pieza);
	
	public Piezas piezaXId(int id);
	
	public Piezas actualizarPieza(Piezas pieza);
	
	public void eliminarPieza(int id);
}
