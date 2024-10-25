package com.ahmed.motos.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.ahmed.motos.dto.MotoDTO;
import com.ahmed.motos.entities.Image;
import com.ahmed.motos.entities.Model;

import com.ahmed.motos.repos.ImageRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ahmed.motos.entities.Moto;
import com.ahmed.motos.repos.MotoRepository;

@Service
public class MotoServiceImpl implements MotoService {
	@Autowired
	MotoRepository motoRepository;
	@Autowired
	ModelMapper modelMappper;

	@Autowired
	ImageRepository imageRepository;

	@Override
	public Moto saveMoto(Moto m) {
		return motoRepository.save(m);
	}
	@Override
	public Moto updateMoto(Moto m) {

		Moto motoUpdated = motoRepository.save(m);

		return motoUpdated;
	}



	@Override
	public void deleteMoto(Moto m) {
		motoRepository.delete(m);
	}
	@Override
	public void deleteMotoById(Long id) {
		Moto m=getMoto(id);
		//suuprimer l'image avant de supprimer le produit

		try {
			Files.delete(Paths.get(System.getProperty("user.home")+"/images111/"+m.getImagePath()));
		}catch (IOException e){
			e.printStackTrace();
		}

		motoRepository.deleteById(id);
	}
	@Override
	public Moto getMoto(Long id) {
		return motoRepository.findById(id).get();
	}
//	@Override
//	public List<MotoDTO> getAllMotos() {
//		return motoRepository.findAll().stream()
//				.map(this::convertEntityToDto)
//				.collect(Collectors.toList());
//	}

	@Override
	public List<Moto> getAllMotos(){
		return motoRepository.findAll();
	}
	@Override
	public List<Moto> findByMarqueMoto(String marque) {
		return this.motoRepository.findByMarqueMoto(marque);
	}

	@Override
	public List<Moto> findByMarqueMotoContains(String marque) {
		return this.motoRepository.findByMarqueMotoContains(marque);
	}

	@Override
	public List<Moto> findByMarquePrix(String marque, Double prix) {
		return this.motoRepository.findByMarquePrix(marque, prix);
	}

	@Override
	public List<Moto> findByModel(Model model) {
		return this.motoRepository.findByModel(model);
	}

	@Override
	public List<Moto> findByModelIdModel(Long id) {
		return this.motoRepository.findByModelIdModel(id);
	}

	@Override
	public List<Moto> findByOrderByMarqueMotoAsc() {
		return this.motoRepository.findByOrderByMarqueMotoAsc();
	}

	@Override
	public List<Moto> trierMotosMarquesPrix() {
		return this.motoRepository.trierMotosMarquesPrix();
	}
	@Override
	public MotoDTO convertEntityToDto(Moto m) {
		modelMappper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		
		MotoDTO motoDTO=modelMappper.map(m, MotoDTO.class);
		
		return motoDTO;
		
		
	}
	@Override
	public Moto convertDtoToEntity(MotoDTO m) {
		return modelMappper.map(m, Moto.class);
	}
}


