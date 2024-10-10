package com.ahmed.motos.service;

import java.util.List;

import com.ahmed.motos.dto.MotoDTO;
import com.ahmed.motos.entities.Model;
import com.ahmed.motos.entities.Moto;

public interface MotoService {
	MotoDTO saveMoto(MotoDTO m);
	MotoDTO updateMoto(MotoDTO m);
	void deleteMoto(Moto m);
	void deleteMotoById(Long id);
	MotoDTO getMoto(Long id);
	List<MotoDTO> getAllMotos();
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
