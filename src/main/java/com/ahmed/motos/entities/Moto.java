package com.ahmed.motos.entities;

import  java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Moto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMoto;
	private String marqueMoto;
	private Double prixMoto;
	private Date dateCreation;
	
	@ManyToOne
	private Model model;
	
	
	public Moto() {
		super();
	}
	
	public Moto(String marqueMoto, Double prixMoto, Date dateCreation) {
		super();
		this.marqueMoto = marqueMoto;
		this.prixMoto = prixMoto;
		this.dateCreation = dateCreation;
	}

	public Long getIdMoto() {
		return idMoto;
	}
	public void setIdMoto(Long idMoto) {
		this.idMoto = idMoto;
	}
	public String getMarqueMoto() {
		return marqueMoto;
	}
	public void setMarqueMoto(String marqueMoto) {
		this.marqueMoto = marqueMoto;
	}
	public Double getPrixMoto() {
		return prixMoto;
	}
	public void setPrixMoto(Double prixMoto) {
		this.prixMoto = prixMoto;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	@Override
	public String toString() {
		return "Moto [idMoto=" + idMoto + ", marqueMoto=" + marqueMoto + ", prixMoto=" + prixMoto + ", dateCreation="
				+ dateCreation + "]";
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

}
