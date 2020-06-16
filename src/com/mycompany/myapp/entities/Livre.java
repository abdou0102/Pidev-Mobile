/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

import java.util.Objects;

/**
 *
 * @author Smirani
 */
public class Livre {
    int id;
    String nom;
    String description;
    String auteur;
    int quantite;
    String image;
    Type id_type; 
    int nbPersonnes;

    public Livre() {
    }

    public Livre(int id, String nom, String description, String auteur, int quantite, String image, Type id_type, int nbPersonnes) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.auteur = auteur;
        this.quantite = quantite;
        this.image = image;
        this.id_type = id_type;
        this.nbPersonnes = nbPersonnes;
    }

    public Livre(String nom, String description, String auteur, int quantite, String image, Type id_type, int nbPersonnes) {
        this.nom = nom;
        this.description = description;
        this.auteur = auteur;
        this.quantite = quantite;
        this.image = image;
        this.id_type = id_type;
        this.nbPersonnes = nbPersonnes;
    }

    
    

    public Livre(int id, String nom, String description, String auteur, int quantite, String image) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.auteur = auteur;
        this.quantite = quantite;
        this.image = image;
    }
    

    public Livre(int id, String nom, String description, String auteur, int quantite, String image, Type id_type) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.auteur = auteur;
        this.quantite = quantite;
        this.image = image;
        this.id_type = id_type;
    }

    public Livre(Type id_type, String nom, String description, String auteur, int quantite, String image) {
        this.nom = nom;
        this.description = description;
        this.auteur = auteur;
        this.quantite = quantite;
        this.image = image;
        this.id_type = id_type;
    }

    public Livre(String nom, String description, String auteur, int quantite, Type id_type) {
        this.nom = nom;
        this.description = description;
        this.auteur = auteur;
        this.quantite = quantite;
        this.id_type = id_type;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Type getId_type() {
        return id_type;
    }

    public void setId_type(Type id_type) {
        this.id_type = id_type;
    }

    public int getNbPersonnes() {
        return nbPersonnes;
    }

    public void setNbPersonnes(int nbPersonnes) {
        this.nbPersonnes = nbPersonnes;
    }

    @Override
    public String toString() {
        return "Livre{" + "id=" + id + ", nom=" + nom + ", description=" + description + ", auteur=" + auteur + ", quantite=" + quantite + ", image=" + image + ", id_type=" + id_type + ", nbPersonnes=" + nbPersonnes + '}';
    }
    
    

    


    
    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Livre other = (Livre) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.quantite != other.quantite) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.auteur, other.auteur)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        if (!Objects.equals(this.id_type, other.id_type)) {
            return false;
        }
        return true;
    }

    
    
    
}
