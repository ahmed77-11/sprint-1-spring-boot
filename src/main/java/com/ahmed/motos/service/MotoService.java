package com.ahmed.motos.service;

import java.util.List;

import com.ahmed.motos.dto.MotoDTO;
import com.ahmed.motos.entities.Model;
import com.ahmed.motos.entities.Moto;

public interface MotoService {
	Moto saveMoto(Moto m);
	Moto updateMoto(Moto m);
	void deleteMoto(Moto m);
	void deleteMotoById(Long id);
	Moto getMoto(Long id);
	List<Moto> getAllMotos();
	List<Moto> findByMarqueMoto(String marque);
	List<Moto> findByMarqueMotoContains(String marque);
	List<Moto> findByMarquePrix (String marque, Double prix);
	List<Moto> findByModel (Model model);
	List<Moto> findByModelIdModel(Long id);
	List<Moto> findByOrderByMarqueMotoAsc();
	List<Moto> trierMotosMarquesPrix();
	
	MotoDTO convertEntityToDto(Moto m);
	Moto convertDtoToEntity(MotoDTO motoDto);
}
