package com.ahmed.motos.dto;

import java.util.Date;

import com.ahmed.motos.entities.Image;
import com.ahmed.motos.entities.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MotoDTO {
	private Long idMoto;
	private String marqueMoto;
	private Double prixMoto;
	private Date dateCreation;
	private Model model;
	private Image image;
	private Image[] images;
	
	
}
