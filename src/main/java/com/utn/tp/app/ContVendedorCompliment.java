package com.utn.tp.app;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.utn.tp.app.RepoUsuario;
import com.utn.tp.app.RepoVendedor;
import com.utn.tp.model.Usuario;
import com.utn.tp.model.Vendedor;

@RestController
@RequestMapping(value = "/Vendedores")
public class ContVendedorCompliment {

	@Autowired
	RepoVendedor RepoVendedor;
	
	@Autowired
	RepoUsuario repoUsuario;
	
	@RequestMapping(method = RequestMethod.GET, value = "")
	public Iterable<Vendedor> getVendedores() {
		return RepoVendedor.findAll();
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST, value = "")
	public void create(@RequestBody Vendedor vendedor) {
		System.out.println(vendedor.getCuit());
		
		if(setUsuario(vendedor)) {
			RepoVendedor.save(vendedor);
		}
	}
	
	public boolean setUsuario(Vendedor vendedor) {
		Optional<Usuario> unUsuario = repoUsuario.findById(vendedor.getUsuario().getId());
		if(unUsuario.isPresent()) {
			
			Usuario usuario = unUsuario.get();
			usuario.setVendedor(vendedor);
			vendedor.setUsuario(usuario);
			
			return true;
		}
		return false;
	}
}
