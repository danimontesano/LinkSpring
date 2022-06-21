package com.utn.tp.app;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.utn.tp.cotizador.Cotizador;
import com.utn.tp.model.Producto;
import com.utn.tp.model.productosDTOs.ProductoDTO;

@RestController
@RequestMapping(value = "/api/Productos")
public class ContProductoCompliment {
	
	@Autowired
	RepoProducto repoProducto;
	
	@RequestMapping(method = RequestMethod.GET, value = "/{productoId}")
	public ProductoDTO getProducto(@PathVariable("productoId") Integer productoId) {
		Optional<Producto> productoOptional = repoProducto.findById(productoId);
		
		if(!productoOptional.isPresent()) {
			throw new ResponseStatusException(
				HttpStatus.NOT_FOUND, "entity not found"
			);
		}else {
			Producto producto = productoOptional.get();
			return new ProductoDTO(
				producto.getId(),
				producto.getNombre(), 
				producto.getDescripcion(), 
				producto.getImagen(), 
				producto.getPrecioDolar(), 
				Cotizador.getInstancia().value.getCompra() * producto.getPrecioDolar(), 
				producto.getVendedor()
			);
		}
	}

}
