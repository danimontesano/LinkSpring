package com.utn.tp.app;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.utn.tp.model.OrdenDeCompra;

@RepositoryRestResource(path="ordenDeCompras")
public interface RepoOrdenDeCompra extends PagingAndSortingRepository<OrdenDeCompra, Integer>{

}
