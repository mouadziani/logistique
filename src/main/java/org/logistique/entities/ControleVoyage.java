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
@Table(name = "controles_voyages")
public class ControleVoyage implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Date date;
	private boolean ficheIteneraire;
	private boolean feuilleControleBagage;
	private boolean presentationChauffeur;
	private boolean climatisation;
	private boolean chauffage;
	private boolean propreteAutocar;
	private String observation;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "chauffeur1_id")
	private Chauffeur chauffeurPremier;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "chauffeur2_id")
	private Chauffeur chauffeurDeuxieme;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "ligne_depart_id")
	private Ligne ligneDepart;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "ligne_arrive_id")
	private Ligne ligneArrive;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "autocar_id")
	private AutoCar autoCar;

	public ControleVoyage() {
	}

	public ControleVoyage(Long id, Date date, boolean ficheIteneraire, boolean feuilleControleBagage,
			boolean presentationChauffeur, boolean climatisation, boolean chauffage, boolean propreteAutocar,
			String observation, Chauffeur chauffeurPremier, Chauffeur chauffeurDeuxieme, Ligne ligneDepart,
			Ligne ligneArrive, AutoCar autoCar) {
		super();
		this.id = id;
		this.date = date;
		this.ficheIteneraire = ficheIteneraire;
		this.feuilleControleBagage = feuilleControleBagage;
		this.presentationChauffeur = presentationChauffeur;
		this.climatisation = climatisation;
		this.chauffage = chauffage;
		this.propreteAutocar = propreteAutocar;
		this.observation = observation;
		this.chauffeurPremier = chauffeurPremier;
		this.chauffeurDeuxieme = chauffeurDeuxieme;
		this.ligneDepart = ligneDepart;
		this.ligneArrive = ligneArrive;
		this.autoCar = autoCar;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isFicheIteneraire() {
		return ficheIteneraire;
	}

	public void setFicheIteneraire(boolean ficheIteneraire) {
		this.ficheIteneraire = ficheIteneraire;
	}

	public boolean isFeuilleControleBagage() {
		return feuilleControleBagage;
	}

	public void setFeuilleControleBagage(boolean feuilleControleBagage) {
		this.feuilleControleBagage = feuilleControleBagage;
	}

	public boolean isPresentationChauffeur() {
		return presentationChauffeur;
	}

	public void setPresentationChauffeur(boolean presentationChauffeur) {
		this.presentationChauffeur = presentationChauffeur;
	}

	public boolean isClimatisation() {
		return climatisation;
	}

	public void setClimatisation(boolean climatisation) {
		this.climatisation = climatisation;
	}

	public boolean isChauffage() {
		return chauffage;
	}

	public void setChauffage(boolean chauffage) {
		this.chauffage = chauffage;
	}

	public boolean isPropreteAutocar() {
		return propreteAutocar;
	}

	public void setPropreteAutocar(boolean propreteAutocar) {
		this.propreteAutocar = propreteAutocar;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
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

	public Ligne getLigneDepart() {
		return ligneDepart;
	}

	public void setLigneDepart(Ligne ligneDepart) {
		this.ligneDepart = ligneDepart;
	}

	public Ligne getLigneArrive() {
		return ligneArrive;
	}

	public void setLigneArrive(Ligne ligneArrive) {
		this.ligneArrive = ligneArrive;
	}

	public AutoCar getAutoCar() {
		return autoCar;
	}

	public void setAutoCar(AutoCar autoCar) {
		this.autoCar = autoCar;
	}

}
