package com.ahmed.motos.service;

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
	public MotoDTO saveMoto(MotoDTO m) {
		return convertEntityToDto(motoRepository.save(convertDtoToEntity(m)));
	}
	@Override
	public MotoDTO updateMoto(MotoDTO m) {
		Long oldMotoImageId =
				this.getMoto(m.getIdMoto()).getImage().getIdImage();
		Long newMotoImageId = m.getImage().getIdImage();
		MotoDTO motoUpdated = convertEntityToDto(motoRepository.save(convertDtoToEntity(m)));
		if (oldMotoImageId != newMotoImageId) { //si l'image a été modifiée
			imageRepository.deleteById(oldMotoImageId);
		}
		return motoUpdated;
	}



	@Override
	public void deleteMoto(Moto m) {
		motoRepository.delete(m);
	}
	@Override
	public void deleteMotoById(Long id) {
		motoRepository.deleteById(id);
	}
	@Override
	public MotoDTO getMoto(Long id) {
		return convertEntityToDto(motoRepository.findById(id).get());
	}
	@Override
	public List<MotoDTO> getAllMotos() {
		return motoRepository.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
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


