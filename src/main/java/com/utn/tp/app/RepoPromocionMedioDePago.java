package com.utn.tp.app;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.utn.tp.model.PromocionMedioDePago;

@RepositoryRestResource(path="promocionMedioDePago")
public interface RepoPromocionMedioDePago extends PagingAndSortingRepository<PromocionMedioDePago, Integer>{

}
