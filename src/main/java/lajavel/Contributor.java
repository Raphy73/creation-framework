package lajavel;

public class Contributor {
    public String firstName;

    public String lastName;
    public String urlImage;
    public String job;
    public String description;
    public String urlTwitter;


    public Contributor(String firstName, String lastName, String urlImage, String job, String description, String urlTwitter)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.urlImage = urlImage;
        this.job = job;
        this.description = description;
        this.urlTwitter = urlTwitter;
    }

    public String getFirstnameAndLastname()
    {
        return firstName + " " + lastName;
    }
}
