package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IProveedoresDAO;
import com.example.demo.dto.Proveedores;

@Service
public class ProveedoresServiceImpl implements IProveedoresService {

	@Autowired
	IProveedoresDAO iProveedoresDAO;
	
	@Override
	public List<Proveedores> listarProveedores() {
		// TODO Auto-generated method stub
		return iProveedoresDAO.findAll();
	}

	@Override
	public Proveedores guardarProveedor(Proveedores proveedor) {
		// TODO Auto-generated method stub
		return iProveedoresDAO.save(proveedor);
	}

	@Override
	public Proveedores proveedorXId(int id) {
		// TODO Auto-generated method stub
		return iProveedoresDAO.findById(id).get();
	}

	@Override
	public Proveedores actualizarProveedor(Proveedores proveedor) {
		// TODO Auto-generated method stub
		return iProveedoresDAO.save(proveedor);
	}

	@Override
	public void eliminarProveedor(int id) {
		// TODO Auto-generated method stub
		iProveedoresDAO.deleteById(id);
		
	}

}
