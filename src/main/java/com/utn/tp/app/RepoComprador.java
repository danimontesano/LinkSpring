package com.utn.tp.app;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.utn.tp.model.Comprador;

@RepositoryRestResource(path="compradores")
public interface RepoComprador extends PagingAndSortingRepository<Comprador, Integer>{

}
