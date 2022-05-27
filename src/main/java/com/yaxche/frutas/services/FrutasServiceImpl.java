package com.yaxche.frutas.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaxche.frutas.model.Frutas;
import com.yaxche.frutas.repo.Fruta_repo;

@Service
public class FrutasServiceImpl implements FrutaService {
	
/*	@Override
	public List<Frutas> guardarAll(Frutas fru) {
		// TODO Auto-generated method stub
		Frutas guardar = new Frutas();
		repo.guardarAll(guardar).forEach(f -> guardar.add(f));
		return guardar;
	}*/

	@Autowired
	private Fruta_repo repo;
	
	@Override
	public List<Frutas> listar() {
		// TODO Auto-generated method stub
		List<Frutas> list = new ArrayList<>();
		repo.findAll().forEach(f -> list.add(f));
		return list;
	}

	@Override
	public Frutas listByClave(String clave) {
		// TODO Auto-generated method stub
		
		return repo.findByClave(clave);
	}

	@Override
	public Frutas agregar(Frutas f) {
		// TODO Auto-generated method stub
		return repo.save(f);
	}

	@Override
	public void delate(String clave) {
		// TODO Auto-generated method stub
		repo.delete(listByClave(clave));
	}

	@Override
	public Frutas buscarClave(String c) {
		// TODO Auto-generated method stub
		Frutas fru = repo.findByClave(c);
		return fru;
	}


}
