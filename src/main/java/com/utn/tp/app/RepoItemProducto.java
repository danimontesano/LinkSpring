package com.utn.tp.app;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.utn.tp.model.ItemProducto;

@RepositoryRestResource(path="itemProducto")
public interface RepoItemProducto extends PagingAndSortingRepository<ItemProducto, Integer> {

}
