package com.yaxche.frutas.fichero;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.yaxche.frutas.model.Frutas;
import com.yaxche.frutas.services.FrutaService;

public class FicheroCSV {
	
	private String nombrecsv;
	private  ArrayList<Frutas> frutas;
	Frutas fruta = new Frutas();
	@Autowired
	FrutaService service;

	public String getNombrecsv() {
		return nombrecsv;
	}

	public void setNombrecsv(String nombrecsv) {
		this.nombrecsv = nombrecsv;
	}

	public ArrayList<Frutas> getFrutas() {
		return frutas;
	}

	public void setFrutas(ArrayList<Frutas> frutas) {
		this.frutas = frutas;
	}
	
	public void mostrarFrutas() {
		
			System.out.println(fruta);
		
	}

	public FicheroCSV(String nombrecsv, ArrayList<Frutas> frutas) {
		this.nombrecsv = nombrecsv;
		if (frutas == null) {
			this.frutas = new ArrayList<>();
		}else {
			this.frutas = frutas;
		}
	}
	
	public void leerFicheroCSV() {
		 FileReader fr;
		 
		 try {
			 fr = new FileReader(this.nombrecsv);
			 String linea = "";
			 BufferedReader br = new BufferedReader(fr);
			 while((linea = br.readLine()) != null) {
				 String[] datoslinea = linea.split(",");
				 Integer idfruta = Integer.valueOf(datoslinea[0].trim());
				 String clavefruta = datoslinea[1].trim();
				 String nombrefruta = datoslinea[2].trim();
				 float preciofruta = Float.valueOf(datoslinea[3].trim());

				 
				 fruta.setClave(clavefruta);
				 fruta.setId(idfruta);
				 fruta.setNombre(nombrefruta);
				 fruta.setPrecio(preciofruta);
			//	 
				/// this.frutas.add(fru);
				 
				// service.agregar(fruta);
			 }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 
	}
	
}
