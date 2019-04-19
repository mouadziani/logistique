package org.logistique.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "autocars")
public class AutoCar implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String matricule;
	private String designation;
	private String descriptionPanne;
	private boolean statut;
	private double duree;

	public AutoCar() {
	}

	public AutoCar(Long id, String designation, String matricule, boolean statut, String descriptionPanne) {
		this.id = id;
		this.designation = designation;
		this.matricule = matricule;
		this.statut = statut;
		this.descriptionPanne = descriptionPanne;
	}

	public AutoCar(String designation, String matricule, boolean statut, String descriptionPanne) {
		this.designation = designation;
		this.matricule = matricule;
		this.statut = statut;
		this.descriptionPanne = descriptionPanne;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public boolean getStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public double getDuree() {
		return duree;
	}

	public void setDuree(double duree) {
		this.duree = duree;
	}

	public String getDescriptionPanne() {
		return descriptionPanne;
	}

	public void setDescriptionPanne(String descriptionPanne) {
		this.descriptionPanne = descriptionPanne;
	}

	@Override
	public String toString() {
		return "AutoCar [id=" + id + ", designation=" + designation + ", matricule=" + matricule + ", statut=" + statut
				+ ", descriptionPanne=" + descriptionPanne + "]";
	}
}
