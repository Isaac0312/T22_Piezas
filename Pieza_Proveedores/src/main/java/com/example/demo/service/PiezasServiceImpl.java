package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IPiezasDAO;
import com.example.demo.dto.Piezas;

@Service
public class PiezasServiceImpl implements IPiezasService {

	@Autowired
	IPiezasDAO iPiezasDAO;
	
	@Override
	public List<Piezas> listarPiezas() {
		// TODO Auto-generated method stub
		return iPiezasDAO.findAll();
	}

	@Override
	public Piezas guardarPieza(Piezas pieza) {
		// TODO Auto-generated method stub
		return iPiezasDAO.save(pieza);
	}

	@Override
	public Piezas piezaXId(int id) {
		// TODO Auto-generated method stub
		return iPiezasDAO.findById(id).get();
	}

	@Override
	public Piezas actualizarPieza(Piezas pieza) {
		// TODO Auto-generated method stub
		return iPiezasDAO.save(pieza);
	}

	@Override
	public void eliminarPieza(int id) {
		// TODO Auto-generated method stub
		iPiezasDAO.deleteById(id);
		
	}

}
