package com.utn.tp.app;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.utn.tp.model.PromocionCupon;

@RepositoryRestResource(path="promocionCupon")
public interface RepoPromocionCupon extends PagingAndSortingRepository<PromocionCupon, Integer> {

}
