package com.utn.tp.cotizador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.utn.tp.cotizador.PrecioDolar.PrecioDolarDTO;

@Component
public class SheduledTasks {
	
	private String dolarResourceUrl = "http://api-dolar-argentina.herokuapp.com/api/dolarblue";
	
	
	@Scheduled(fixedRate = 30 * 60 * 1000, initialDelay = 1000)
	//@Scheduled(fixedDelay = 1000, initialDelay = 1000)
	public void scheduleFixedRateTask() throws ParseException {
	    
	    RestTemplate restTemplate = new RestTemplate();
	    
	    PrecioDolarDTO precioDolarDTO = restTemplate.getForObject(dolarResourceUrl, PrecioDolar.PrecioDolarDTO.class);
	    SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    dateFormater.setTimeZone(TimeZone.getTimeZone("UTC"));
	    Date date = dateFormater.parse(precioDolarDTO.getFecha());
	    
	    Cotizador cotizador = Cotizador.getInstancia();
	    cotizador.value.actualizar(date, precioDolarDTO.getCompra(), precioDolarDTO.getVenta());    
	    
	    System.out.println("-Cotizador actualizado a las: " + cotizador.value.getFecha() + "\n-Nuevo valor: " + cotizador.value.getCompra() + "\n");
	}

}
