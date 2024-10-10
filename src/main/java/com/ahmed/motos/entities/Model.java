package com.ahmed.motos.entities;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
public class Model {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idModel;
	private String nomModel;
	private String descriptionModel;

	@JsonIgnore
	@JsonManagedReference
	@OneToMany(mappedBy = "model")// model and motos relie with an attribut called model
	private List<Moto> motos;

	public Model() {
	}

	public Model(String nomModel, String descriptionModel, List<Moto> motos) {
		super();
		this.nomModel = nomModel;
		this.descriptionModel = descriptionModel;
		this.motos = motos;
	}

	public long getIdModel() {
		return idModel;
	}

	public void setIdModel(long idModel) {
		this.idModel = idModel;
	}

	public String getNomModel() {
		return nomModel;
	}

	public void setNomModel(String nomModel) {
		this.nomModel = nomModel;
	}

	public String getDescriptionModel() {
		return descriptionModel;
	}

	public void setDescriptionModel(String descriptionModel) {
		this.descriptionModel = descriptionModel;
	}

	public List<Moto> getMotos() {
		return motos;
	}

	public void setMotos(List<Moto> motos) {
		this.motos = motos;
	}
}






