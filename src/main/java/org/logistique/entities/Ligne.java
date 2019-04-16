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
@Table(name = "lignes")
public class Ligne implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "ville_depart_id")
	private Ville villeDepart;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "ville_arrive_id")
	private Ville villeArrive;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "ville_escale_id")
	private Ville villeEscale;

	private Date dateDepart;
	private double heurDepart;
	private Date dateArrive;
	private double heurArrive;
	private Date dateRetour;
	private double heurRetour;
	private double dureeVoyage;
	private double dureeRepos;
	private double dureeImmob;
	private double kilometrage;

	public Ligne() {
	}

	public Ligne(Long id, Ville villeDepart, Ville villeArrive, Ville villeEscale, Date dateDepart, double heurDepart,
			Date dateArrive, double heurArrive, Date dateRetour, double heurRetour, double dureeVoyage,
			double dureeRepos, double dureeImmob, double kilometrage) {
		this.id = id;
		this.villeDepart = villeDepart;
		this.villeArrive = villeArrive;
		this.villeEscale = villeEscale;
		this.dateDepart = dateDepart;
		this.heurDepart = heurDepart;
		this.dateArrive = dateArrive;
		this.heurArrive = heurArrive;
		this.dateRetour = dateRetour;
		this.heurRetour = heurRetour;
		this.dureeVoyage = dureeVoyage;
		this.dureeRepos = dureeRepos;
		this.dureeImmob = dureeImmob;
		this.kilometrage = kilometrage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ville getVilleDepart() {
		return villeDepart;
	}

	public void setVilleDepart(Ville villeDepart) {
		this.villeDepart = villeDepart;
	}

	public Ville getVilleArrive() {
		return villeArrive;
	}

	public void setVilleArrive(Ville villeArrive) {
		this.villeArrive = villeArrive;
	}

	public Ville getVilleEscale() {
		return villeEscale;
	}

	public void setVilleEscale(Ville villeEscale) {
		this.villeEscale = villeEscale;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public double getHeurDepart() {
		return heurDepart;
	}

	public void setHeurDepart(double heurDepart) {
		this.heurDepart = heurDepart;
	}

	public Date getDateArrive() {
		return dateArrive;
	}

	public void setDateArrive(Date dateArrive) {
		this.dateArrive = dateArrive;
	}

	public double getHeurArrive() {
		return heurArrive;
	}

	public void setHeurArrive(double heurArrive) {
		this.heurArrive = heurArrive;
	}

	public Date getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}

	public double getHeurRetour() {
		return heurRetour;
	}

	public void setHeurRetour(double heurRetour) {
		this.heurRetour = heurRetour;
	}

	public double getDureeVoyage() {
		return dureeVoyage;
	}

	public void setDureeVoyage(double dureeVoyage) {
		this.dureeVoyage = dureeVoyage;
	}

	public double getDureeRepos() {
		return dureeRepos;
	}

	public void setDureeRepos(double dureeRepos) {
		this.dureeRepos = dureeRepos;
	}

	public double getDureeImmob() {
		return dureeImmob;
	}

	public void setDureeImmob(double dureeImmob) {
		this.dureeImmob = dureeImmob;
	}

	public double getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(double kilometrage) {
		this.kilometrage = kilometrage;
	}
}
