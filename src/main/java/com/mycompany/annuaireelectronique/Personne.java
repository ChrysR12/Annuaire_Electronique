/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.mycompany.annuaireelectronique;

/**
 *
 * @author Inclu
 */
public class Personne {
    private int id;
    private String rentree;
    private String localisation;
    private String etablissement;
    private String secteur;
    private String genre;
    private String nom;
    private String prenom;
    
    public Personne(int id, String rentree, String localisation, String etablissement, String secteur, String genre, String nom, String prenom) {
        this.id = id;
        this.rentree = rentree;
        this.localisation = localisation;
        this.etablissement = etablissement;
        this.secteur = secteur;
        this.genre = genre;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRentree() {
        return rentree;
    }

    public void setRentree(String rentree) {
        this.rentree = rentree;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    
}

