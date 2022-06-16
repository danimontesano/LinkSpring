package com.utn.tp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.stereotype.Component;

import com.utn.tp.app.RepoComprador;
import com.utn.tp.app.RepoDireccion;
import com.utn.tp.app.RepoItemProducto;
import com.utn.tp.app.RepoOrdenDeCompra;
import com.utn.tp.app.RepoProducto;
import com.utn.tp.app.RepoPromocionCupon;
import com.utn.tp.app.RepoPromocionMedioDePago;
import com.utn.tp.app.RepoProveedor;
import com.utn.tp.app.RepoUsuario;
import com.utn.tp.app.RepoVendedor;
import com.utn.tp.model.Comprador;
import com.utn.tp.model.Direccion;
import com.utn.tp.model.ItemProducto;
import com.utn.tp.model.MetodoDePago;
import com.utn.tp.model.OrdenDeCompra;
import com.utn.tp.model.Producto;
import com.utn.tp.model.PromocionCupon;
import com.utn.tp.model.PromocionMedioDePago;
import com.utn.tp.model.Proveedor;
import com.utn.tp.model.TipoDescuento;
import com.utn.tp.model.Usuario;
import com.utn.tp.model.Vendedor;

@Component
public class InitData implements CommandLineRunner{
	
	@Autowired
	RepoPromocionCupon RepoPromocionCupon;
	
	@Autowired
	RepoPromocionMedioDePago RepoPromocionMedioDePago;
	
	@Autowired
	RepoUsuario repoUsuario;
	
	@Autowired
	RepoDireccion repoDireccion;
	
	@Autowired
	RepoProveedor repoProveedor;
	
	@Autowired
	RepoComprador repoComprador;
	
	@Autowired
	RepoVendedor repoVendedor;
	
	@Autowired
	RepoProducto repoProducto;
	
	@Autowired
	RepoItemProducto repoItemProducto;
	
	@Autowired
	RepoOrdenDeCompra repoOrdenDeCompra;
	
	@Autowired
	RepositoryRestConfiguration config;
	
	@Transactional
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		config.getProjectionConfiguration().addProjection(AlumnoDTO2.class);
//		config.exposeIdsFor(Materia.class, Alumno.class);
		
		//config.exposeIdsFor(OrdenDeCompra.class);
		
		if(repoUsuario.count() != 0) {
			return;
		}
		
		//Creacion de promociones
		PromocionCupon promocionCupon1 = new PromocionCupon(TipoDescuento.FIJO, 1000f, true, "AABBCCDDEE");
		PromocionCupon promocionCupon2 = new PromocionCupon(TipoDescuento.FIJO, 1000f, true, "FFGGHHII");
		PromocionMedioDePago promocionMedioDePago3 = new PromocionMedioDePago(TipoDescuento.PROCENTUAL, 10f, true, MetodoDePago.EFECTIVO);
		RepoPromocionCupon.save(promocionCupon1);
		RepoPromocionCupon.save(promocionCupon2);
		RepoPromocionMedioDePago.save(promocionMedioDePago3);
		
		//Creacion de proveedores
		Proveedor proveedor1 = new Proveedor("proveedor1");
		Proveedor proveedor2 = new Proveedor("proveedor2");
		Proveedor proveedor3 = new Proveedor("proveedor3");
		repoProveedor.save(proveedor1);
		repoProveedor.save(proveedor2);
		repoProveedor.save(proveedor3);
		
		//Creacion de direcciones
		Direccion direccion1 = new Direccion("calle1", 1111, "11AA");
		Direccion direccion2 = new Direccion("calle2", 2222, "22BB");
		Direccion direccion3 =new Direccion("calle3", 3333, "33CC");
		repoDireccion.save(direccion1);
		repoDireccion.save(direccion2);
		repoDireccion.save(direccion3);
		
		//Creacion de usuario
		Usuario usuario1 = new Usuario("nombre1", "apellido1", direccion1);
		Usuario usuario2 = new Usuario("nombre2", "apellido2", direccion2);
		Usuario usuario3 = new Usuario("nombre3", "apellido3", direccion3);
		List<Usuario> usuariosIniciales = Arrays.asList(
				usuario1,
				usuario2,
				usuario3
				);
		
		usuariosIniciales.stream().forEach(usuario->{
			repoUsuario.save(usuario);
		});
		

		//Creacion de compradores
		Comprador comprador1 = new Comprador(usuario1, 43176108, new ArrayList<>(), new ArrayList<>());
		Comprador comprador2 = new Comprador(usuario3, 43176108, new ArrayList<>(), new ArrayList<>());
		repoComprador.save(comprador1);
		repoComprador.save(comprador2);
		
		//Creacion de vendedores
		Vendedor vendedor1 = new Vendedor(usuario2, "Empresa 1", "30-98327389-4", Arrays.asList(proveedor1, proveedor2));
		Vendedor vendedor2 = new Vendedor(usuario3, "Empresa 2", "25-83728930-5", Arrays.asList(proveedor1, proveedor2, proveedor3));
		repoVendedor.save(vendedor1);
		repoVendedor.save(vendedor2);
		
		//Creacion de productos
		Producto producto1 = new Producto("producto 1", "descripcion del producto 1", 30.50f, vendedor1);
		Producto producto2 = new Producto("producto 2", "descripcion del producto 2", 39.99f, vendedor1);
		Producto producto3 = new Producto("producto 3", "descripcion del producto 3", 34.99f, vendedor1);
		Producto producto4 = new Producto("producto 4", "descripcion del producto 4", 32.00f, vendedor2);
		Producto producto5 = new Producto("producto 5", "descripcion del producto 5", 35.00f, vendedor2);
		repoProducto.save(producto1);
		repoProducto.save(producto2);
		repoProducto.save(producto3);
		repoProducto.save(producto4);
		repoProducto.save(producto5);
				
		//Creacion de items producto
		ItemProducto item1 = new ItemProducto(producto1, 2, 400.0f);
		ItemProducto item2 = new ItemProducto(producto2, 4, 1200.0f);
		ItemProducto item3 = new ItemProducto(producto1, 2, 400.0f);
		ItemProducto item4 = new ItemProducto(producto4, 4, 1200.0f);
		ItemProducto item5 = new ItemProducto(producto1, 6, 4000.0f);
		ItemProducto item6 = new ItemProducto(producto5, 1, 1070.0f);
		List<ItemProducto> itemsIniciales = Arrays.asList(
				item1, item2, item3, item4, item5, item6
				);
		
		itemsIniciales.stream().forEach(item->{
			repoItemProducto.save(item);
		});
		
		//Creacion de ordenes de compra
		OrdenDeCompra orden1 = new OrdenDeCompra(Arrays.asList(item1, item2), LocalDate.now(), comprador1, vendedor1);
		OrdenDeCompra orden2 = new OrdenDeCompra(Arrays.asList(item3, item4), LocalDate.now(), comprador1, vendedor2);
		OrdenDeCompra orden3 = new OrdenDeCompra(Arrays.asList(item5, item6), LocalDate.now(), comprador2, vendedor2);
		repoOrdenDeCompra.save(orden1);
		repoOrdenDeCompra.save(orden2);
		repoOrdenDeCompra.save(orden3);
		
	}
	
}
