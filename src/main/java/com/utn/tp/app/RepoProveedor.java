package com.utn.tp.app;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.utn.tp.model.Proveedor;

@RepositoryRestResource(path="proveedores")
public interface RepoProveedor extends PagingAndSortingRepository<Proveedor, Integer> {

}
