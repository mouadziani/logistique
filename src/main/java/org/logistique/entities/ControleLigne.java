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
@Table(name = "controles_lignes")
public class ControleLigne implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Date date;
	private double heur;
	private String lieu;
	private int nbreVoyageurs;
	private int nbreVoyageursControle;
	private String numFeuilleRoute;
	private String numSerieControle;
	private boolean boiteFarmain;
	private boolean disponibiliteExtructeur;
	private boolean ceintureSecuriteChauffeur;
	private boolean ceinture_securite_voyageur;
	private boolean tachygraphe;

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

	public ControleLigne() {
	}

	public ControleLigne(Long id, Date date, double heur, String lieu, int nbreVoyageurs, int nbreVoyageursControle,
			String numFeuilleRoute, String numSerieControle, boolean boiteFarmain, boolean disponibiliteExtructeur,
			boolean ceintureSecuriteChauffeur, boolean ceinture_securite_voyageur, boolean tachygraphe,
			Chauffeur chauffeurPremier, Chauffeur chauffeurDeuxieme, Ligne ligne, AutoCar autoCar) {
		this.id = id;
		this.date = date;
		this.heur = heur;
		this.lieu = lieu;
		this.nbreVoyageurs = nbreVoyageurs;
		this.nbreVoyageursControle = nbreVoyageursControle;
		this.numFeuilleRoute = numFeuilleRoute;
		this.numSerieControle = numSerieControle;
		this.boiteFarmain = boiteFarmain;
		this.disponibiliteExtructeur = disponibiliteExtructeur;
		this.ceintureSecuriteChauffeur = ceintureSecuriteChauffeur;
		this.ceinture_securite_voyageur = ceinture_securite_voyageur;
		this.tachygraphe = tachygraphe;
		this.chauffeurPremier = chauffeurPremier;
		this.chauffeurDeuxieme = chauffeurDeuxieme;
		this.ligne = ligne;
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

	public double getHeur() {
		return heur;
	}

	public void setHeur(double heur) {
		this.heur = heur;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public int getNbreVoyageurs() {
		return nbreVoyageurs;
	}

	public void setNbreVoyageurs(int nbreVoyageurs) {
		this.nbreVoyageurs = nbreVoyageurs;
	}

	public int getNbreVoyageursControle() {
		return nbreVoyageursControle;
	}

	public void setNbreVoyageursControle(int nbreVoyageursControle) {
		this.nbreVoyageursControle = nbreVoyageursControle;
	}

	public String getNumFeuilleRoute() {
		return numFeuilleRoute;
	}

	public void setNumFeuilleRoute(String numFeuilleRoute) {
		this.numFeuilleRoute = numFeuilleRoute;
	}

	public String getNumSerieControle() {
		return numSerieControle;
	}

	public void setNumSerieControle(String numSerieControle) {
		this.numSerieControle = numSerieControle;
	}

	public boolean isBoiteFarmain() {
		return boiteFarmain;
	}

	public void setBoiteFarmain(boolean boiteFarmain) {
		this.boiteFarmain = boiteFarmain;
	}

	public boolean isDisponibiliteExtructeur() {
		return disponibiliteExtructeur;
	}

	public void setDisponibiliteExtructeur(boolean disponibiliteExtructeur) {
		this.disponibiliteExtructeur = disponibiliteExtructeur;
	}

	public boolean isCeintureSecuriteChauffeur() {
		return ceintureSecuriteChauffeur;
	}

	public void setCeintureSecuriteChauffeur(boolean ceintureSecuriteChauffeur) {
		this.ceintureSecuriteChauffeur = ceintureSecuriteChauffeur;
	}

	public boolean isCeinture_securite_voyageur() {
		return ceinture_securite_voyageur;
	}

	public void setCeinture_securite_voyageur(boolean ceinture_securite_voyageur) {
		this.ceinture_securite_voyageur = ceinture_securite_voyageur;
	}

	public boolean isTachygraphe() {
		return tachygraphe;
	}

	public void setTachygraphe(boolean tachygraphe) {
		this.tachygraphe = tachygraphe;
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

	public AutoCar getAutoCar() {
		return autoCar;
	}

	public void setAutoCar(AutoCar autoCar) {
		this.autoCar = autoCar;
	}

}
