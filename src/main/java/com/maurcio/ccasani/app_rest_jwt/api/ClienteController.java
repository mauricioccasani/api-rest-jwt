package com.maurcio.ccasani.app_rest_jwt.api;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maurcio.ccasani.app_rest_jwt.entity.Cliente;
import com.maurcio.ccasani.app_rest_jwt.service.exeptionService.ExceptionService;
import com.maurcio.ccasani.app_rest_jwt.service.inf.IClienteServiceInf;

import lombok.Data;

@SuppressWarnings("serial")
@RestController
@RequestMapping("/api-v1")
@CrossOrigin(origins = "http://localhost:8082/api-v1/")
@Data
public class ClienteController implements Serializable {
	@Autowired
	private IClienteServiceInf clienteService;

	@GetMapping("/clientes")
	public List<Cliente> listarCliente() {
		List<Cliente> listarCliente = null;
		try {
			listarCliente = this.getClienteService().findAll();
		} catch (ExceptionService e) {
			e.printStackTrace();
		}
		return listarCliente;
	}
	//Metodo para buscar por id
	@GetMapping("/clientes/{id}")
	public Cliente buscarXid(@PathVariable Integer id) {
		Cliente cliente = null;
		try {
			cliente = this.getClienteService().findById(id);
		} catch (ExceptionService e) {
			e.printStackTrace();
		}
		return cliente;
	}

	@PostMapping("/clientes")
	public Cliente registrar(@RequestBody Cliente cliente) {
		Cliente oCliente = null;
		try {
			oCliente = this.getClienteService().save(cliente);
		} catch (ExceptionService e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oCliente;
	}

	@PutMapping("/clientes/{id}")
	public Cliente actualizar(@RequestBody Cliente cliente, @PathVariable Integer id) throws ExceptionService {
		Cliente oCliente = null;
		try {
			oCliente = this.getClienteService().findById(id);
			oCliente.setNombres(cliente.getNombres());
			oCliente.setApellidos(cliente.getApellidos());
			oCliente.setFecha(cliente.getFecha());

		} catch (ExceptionService e) {
			e.printStackTrace();
		}

		return this.getClienteService().save(oCliente);
	}
	@DeleteMapping("/clientes/{id}")
	public void delete(@PathVariable Integer id) {
		try {
			this.getClienteService().deleteById(id);
		} catch (ExceptionService e) {
			
			e.printStackTrace();
		}
	}
}
