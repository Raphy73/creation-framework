package lajavel;

public class Voiture
{
    public String couleur;
    public String marque;

    public Voiture(String couleur, String marque)
    {
        this.couleur = couleur;
        this.marque = marque;
    }

    public String getFirstnameAndLastname()
    {
        return couleur + " " + marque;
    }
}