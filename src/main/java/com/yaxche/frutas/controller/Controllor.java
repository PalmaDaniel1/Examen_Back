package com.yaxche.frutas.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yaxche.frutas.model.Frutas;
import com.yaxche.frutas.services.FrutaService;

@RestController
@CrossOrigin(origins= "http://localhost:4200", maxAge = 3600)
@RequestMapping({"/frutas"})
public class Controllor {
	
	@Autowired
	FrutaService service;
	
	//private String nombrecsv;

	
	@GetMapping("/listar")
	public List<Frutas>listar(){
		return service.listar();
	}
	
	@GetMapping("/buscar/{clave}")
	public Frutas buscarFrutas(@PathVariable(value = "clave") String clave) {
		Frutas fru = service.buscarClave(clave);
		return fru;
	}
	
	@PostMapping("/agregar")
	public Frutas agregar(@RequestBody Frutas f) {
		return service.agregar(f);
	}
	

	@PatchMapping(value = "/actualizar/{clave}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Frutas actualizar(@PathVariable String clave, @RequestBody Map<Object, Object> fields) {
		Frutas re = buscarFrutas(clave);
		fields.forEach((k,v) -> {
			Field field  =  ReflectionUtils.findField(Frutas.class, k.toString());
			field.setAccessible(true);
			ReflectionUtils.setField(field, re, v);
		});
		return service.agregar(re);
	}
	
	@GetMapping("/leerFichero")
	public List<Frutas>leerFichero() {
		String dirFicheroCSV = "frutas.csv";	
		Frutas fruta = new Frutas();
			 FileReader fr;			 
			 try {
				 fr = new FileReader(dirFicheroCSV);
				 String linea = "";
				 try (BufferedReader br = new BufferedReader(fr)) {
					while((linea = br.readLine()) != null) {
						 String[] datoslinea = linea.split(",");
						 Integer idfruta = Integer.valueOf(datoslinea[0].trim());
						 String clavefruta = datoslinea[1].trim();
						 String nombrefruta = datoslinea[2].trim();
						 float preciofruta = Float.valueOf(datoslinea[3].trim());
						 //Seteamos los datos
						 fruta.setClave(clavefruta);
						 fruta.setId(idfruta);
						 fruta.setNombre(nombrefruta);
						 fruta.setPrecio(preciofruta);
						 agregar(fruta);
						
					 }
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		return service.listar();
	}

}
