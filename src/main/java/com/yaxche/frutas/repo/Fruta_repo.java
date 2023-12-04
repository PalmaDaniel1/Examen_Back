package com.yaxche.frutas.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.yaxche.frutas.model.Frutas;
import org.springframework.stereotype.Repository;

@Repository
public interface Fruta_repo extends CrudRepository<Frutas, Integer>{
	List<Frutas>findAll();
	@SuppressWarnings("unchecked")
	Frutas save(Frutas frut);
	void delete(Frutas frut);
	Frutas findByClave(String clave);
	///List<Frutas>guardarAll(Frutas fru);

}
