package com.utn.tp.app;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.utn.tp.model.Direccion;

@RepositoryRestResource(path="direcciones")
public interface RepoDireccion extends PagingAndSortingRepository<Direccion, Integer> {

}
