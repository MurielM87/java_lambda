package fr.lambda.cours.calculatrice;

public class Stagiaires {
    private String nom;
    private String prenom;
    private boolean relou;

    public Stagiaires(String nom, String prenom, boolean relou) {
        this.nom = nom;
        this.prenom = prenom;
        this.relou = relou;
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

    public boolean isRelou() {
        return relou;
    }

    public void setRelou(boolean relou) {
        this.relou = relou;
    }
}
