package com.maurcio.ccasani.app_rest_jwt.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maurcio.ccasani.app_rest_jwt.dao.ClienteDao;
import com.maurcio.ccasani.app_rest_jwt.entity.Cliente;
import com.maurcio.ccasani.app_rest_jwt.service.exeptionService.ExceptionService;
import com.maurcio.ccasani.app_rest_jwt.service.inf.IClienteServiceInf;

import lombok.Data;

@Service
@Data
public class ClienteServiceImpl implements IClienteServiceInf {
	@Autowired
	private ClienteDao clienteDao;

	@Override
	public List<Cliente> findAll() throws ExceptionService {
		try {
			return this.getClienteDao().findAll();
		} catch (Exception e) {
			throw new ExceptionService("Error al listar clientes " + e.getMessage());
		}
	}

	@Override
	public Cliente save(Cliente t) throws ExceptionService {
		try {
			return this.getClienteDao().save(t);
		} catch (Exception e) {
			throw new ExceptionService("Error al  registrar cliente " + e.getMessage());
		}
	}

	@Override
	public Cliente findById(Integer id) throws ExceptionService {
		try {
			Cliente cliente = new Cliente();
			Optional<Cliente> optCliente = this.getClienteDao().findById(id);
			if (optCliente.isPresent()) {
				cliente = optCliente.get();
			}
			return cliente;
		} catch (Exception e) {
			throw new ExceptionService("Error al  buscar id cliente " + e.getMessage());
		}
	}

	@Override
	public void deleteById(Integer id) throws ExceptionService {
		try {
			this.getClienteDao().deleteById(id);
		} catch (Exception e) {
			throw new ExceptionService("Error al  eliminar cliente " + e.getMessage());
		}
	}

}
