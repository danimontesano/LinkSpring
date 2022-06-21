package com.utn.tp.app;

import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.utn.tp.model.Comprador;
import com.utn.tp.model.ItemProducto;
import com.utn.tp.model.Producto;
import com.utn.tp.model.Usuario;

@RestController
@RequestMapping(value = "/api/Compradores")
public class ContCompradorCompliment {

	@Autowired
	RepoUsuario repoUsuario;
	
	@Autowired
	RepoComprador repoComprador;
	
	@Autowired
	RepoProducto repoProducto;
	
	@Autowired
	RepoItemProducto repoItemProducto;
	
	@RequestMapping(method = RequestMethod.GET, value = "")
	public Iterable<Comprador> getCompradores() {
		return repoComprador.findAll();
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST, value = "")
	public void create(@RequestBody Comprador comprador) {
		System.out.println(comprador.getNumeroDocumento());
		
		if(setUsuario(comprador)) {
			repoComprador.save(comprador);
		}
	}
	
	public boolean setUsuario(Comprador comprador) {
		Optional<Usuario> unUsuario = repoUsuario.findById(comprador.getUsuario().getId());
		if(unUsuario.isPresent()) {
			
			Usuario usuario = unUsuario.get();
			usuario.setComprador(comprador);
			comprador.setUsuario(usuario);
			
			return true;
		}
		return false;
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST, value = "/{usuarioId}/itemProducto")
	public void agregarItemCarrito(@PathVariable("usuarioId") UUID usuarioId, @RequestBody ItemProducto itemProducto) {
		Optional<Usuario> unUsuario = repoUsuario.findById(usuarioId);
		Optional<Producto> unProducto = repoProducto.findById(itemProducto.getProducto().getId());
		if(unUsuario.isPresent() && unProducto.isPresent()) {
			Producto producto = unProducto.get();
			itemProducto.setProducto(producto);
			repoItemProducto.save(itemProducto);
			
			Comprador comprador = unUsuario.get().getComprador();
			comprador.getCarritoCompras().add(itemProducto);
		}
	}
}
