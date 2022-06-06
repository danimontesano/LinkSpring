package com.utn.tp.app;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.utn.tp.model.Producto;

@RepositoryRestResource(path="productos")
public interface RepoProducto extends PagingAndSortingRepository<Producto, Integer> {

}
