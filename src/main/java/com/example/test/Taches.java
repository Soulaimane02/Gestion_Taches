package com.example.test;

public class Taches {
    private String nom;
    private String description;
    private String importance;

    public Taches(String n,String d,String i)
    {
        this.nom = n;
        this.description =d;
        this.importance = i;
    }
    public String getDescription() {
        return description;
    }
    public String getNom() {
        return nom;
    }
    public String isImportance() {
        return importance;
    }
    public void setImportance(String importance) {
        this.importance = importance;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getImportance()
    {
        return this.importance;
    }
}
