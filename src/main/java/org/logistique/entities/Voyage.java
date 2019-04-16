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
@Table(name = "voyages")
public class Voyage implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "chauffeur1_id")
	private Chauffeur chauffeurPremier;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "chauffeur2_id")
	private Chauffeur chauffeurDeuxieme;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "ligne_id")
	private Ligne ligne;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "autocar_id")
	private AutoCar autoCar;

	private Date date;

	public Voyage() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Chauffeur getChauffeurPremier() {
		return chauffeurPremier;
	}

	public void setChauffeurPremier(Chauffeur chauffeurPremier) {
		this.chauffeurPremier = chauffeurPremier;
	}

	public Chauffeur getChauffeurDeuxieme() {
		return chauffeurDeuxieme;
	}

	public void setChauffeurDeuxieme(Chauffeur chauffeurDeuxieme) {
		this.chauffeurDeuxieme = chauffeurDeuxieme;
	}

	public Ligne getLigne() {
		return ligne;
	}

	public void setLigne(Ligne ligne) {
		this.ligne = ligne;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public AutoCar getAutoCar() {
		return autoCar;
	}

	public void setAutoCar(AutoCar autoCar) {
		this.autoCar = autoCar;
	}

	public Voyage(Long id, Chauffeur chauffeurPremier, Chauffeur chauffeurDeuxieme, Ligne ligne, Date date,
			AutoCar autoCar) {
		super();
		this.id = id;
		this.chauffeurPremier = chauffeurPremier;
		this.chauffeurDeuxieme = chauffeurDeuxieme;
		this.ligne = ligne;
		this.date = date;
		this.autoCar = autoCar;
	}
}
