package com.utn.tp.app;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.utn.tp.app.RepoDireccion;
import com.utn.tp.app.RepoUsuario;
import com.utn.tp.cotizador.Cotizador;
import com.utn.tp.model.Usuario;

//@RepositoryRestController
@RestController
@RequestMapping(value = "/Usuarios")
public class ContUsuarioCompliment {

	@Autowired
	RepoUsuario repoUsuario;

	@Autowired
	RepoDireccion repoDireccion;

	
	@Transactional
	@RequestMapping(method = RequestMethod.POST, value = "")
	public void create(@RequestBody Usuario usuario) {
		System.out.println(usuario.getApellido());
		repoDireccion.save(usuario.getDireccion());
		repoUsuario.save(usuario);
	}

	@RequestMapping(method = RequestMethod.GET, value = "")
	public @ResponseBody Iterable<Usuario> getUsuarios() {
		
		return repoUsuario.findAll();

	}
	
	
	
	
//	@Autowired
//	//PagedResourcesAssembler assembler;
//	RepresentationModelAssembler<Usuario, EntityModel<Usuario>> assembler;
//	
//	@Autowired
//	private PagedResourcesAssembler<Usuario> pagedResourcesAssembler;
//	@RequestMapping(method = RequestMethod.GET, value = "/usuarios")
//	public ResponseEntity<?> getUsuarios(Pageable page) {
//		
//		Page<Usuario> usuario= repoUsuario.findAll(page);
//		
//		return new ResponseEntity<>(pagedResourcesAssembler.toModel(usuario, assembler), HttpStatus.OK);
//
//	}
}
