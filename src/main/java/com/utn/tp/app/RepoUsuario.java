package com.utn.tp.app;


import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.utn.tp.model.Usuario;

@RepositoryRestResource(collectionResourceRel = "usuarios", path="usuarios")
public interface RepoUsuario extends PagingAndSortingRepository<Usuario, UUID> {
	Page<Usuario> findAll(Pageable page);
	
	List<Usuario> findAll();
}
