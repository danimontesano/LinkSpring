package com.utn.tp.app;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.utn.tp.model.Vendedor;

@RepositoryRestResource(path="vendedores")
public interface RepoVendedor extends PagingAndSortingRepository<Vendedor, UUID> {

}
