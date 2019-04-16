package org.logistique.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "locations")
public class Location implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String intitule;
	private String benificiaire;
	private Date dateDebut;
	private Date dateFin;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "chauffeur_id")
	private Chauffeur chauffeur;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "autocar_id")
	private AutoCar autoCar;

	public Location() {
	}

	public Location(Long id, String intitule, String benificiaire, Date dateDebut, Date dateFin, Chauffeur chauffeur,
			AutoCar autoCar) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.benificiaire = benificiaire;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.chauffeur = chauffeur;
		this.autoCar = autoCar;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getBenificiaire() {
		return benificiaire;
	}

	public void setBenificiaire(String benificiaire) {
		this.benificiaire = benificiaire;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Chauffeur getChauffeur() {
		return chauffeur;
	}

	public void setChauffeur(Chauffeur chauffeur) {
		this.chauffeur = chauffeur;
	}

	public AutoCar getAutoCar() {
		return autoCar;
	}

	public void setAutoCar(AutoCar autoCar) {
		this.autoCar = autoCar;
	}
}
