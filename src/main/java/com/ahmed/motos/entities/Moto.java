package com.ahmed.motos.entities;

import  java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

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


	@OneToMany(mappedBy = "moto")
	private List<Image> images;

	private String imagePath;
	
	
	public Moto() {
		super();
	}




	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getImagePath() {
		return imagePath;
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

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}
}
