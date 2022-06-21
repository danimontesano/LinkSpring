package com.utn.tp.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Usuarios")
public class ContCarrito {
	
	@Autowired
	RepoComprador repoComprador;

}
