package com.yaxche.frutas.services;

import java.util.List;

import com.yaxche.frutas.model.Frutas;

public interface FrutaService {
	List<Frutas>listar();
	//List<Frutas>guardarAll();
	Frutas listByClave(String clave);
	Frutas agregar(Frutas f);
	void delate(String clave);
	Frutas buscarClave(String c);
	//List<Frutas> guardarAll(Frutas fru);

}
