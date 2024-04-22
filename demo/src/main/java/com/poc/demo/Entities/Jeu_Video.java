package com.poc.demo.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Jeu_Video")
public class Jeu_Video {
    private @Id @GeneratedValue Long id;
    private String titre;
    private String editeur;
    private String genre;
    private Double prix = 0.0d;
    private @Column(length=500) String description;

    //Constructeur par défault pour Spring
    public Jeu_Video() { }
    //Constructeur pour init les attributs
    public Jeu_Video(String titre, String editeur, String genre, Double prix, String description) {
        this.titre = titre;
        this.editeur = editeur;
        this.genre = genre;
        this.prix = prix;
        this.description = description;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }
    public String getEditeur() { return editeur; }
    public void setEditeur(String editeur) { this.editeur = editeur; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    public Double getPrix() { return prix; }
    public void setPrix(Double prix) {  this.prix = prix; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    
}
