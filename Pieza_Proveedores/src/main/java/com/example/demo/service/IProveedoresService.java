package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Proveedores;

public interface IProveedoresService {
	
	public List<Proveedores> listarProveedores();
	
	public Proveedores guardarProveedor(Proveedores proveedor);
	
	public Proveedores proveedorXId(int id);
	
	public Proveedores actualizarProveedor(Proveedores proveedor);
	
	public void eliminarProveedor(int id);
}
