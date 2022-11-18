package app.Repository;

import app.Model.Partner;

import javax.servlet.http.Part;
import java.util.ArrayList;
import java.util.List;

public final class PartnerRepository {
    private static PartnerRepository instance;
    private final List<Partner> allTheElements;

    private PartnerRepository()
    {
        Partner partner1 = new Partner("1-client", "http://www.boucherie-ayet-chambery.com");
        Partner partner2 = new Partner("2-client", "https://www.skyrock.com/blog/");
        Partner partner3 = new Partner("3-client", "https://www.alcatelmobile.com/fr/");
        Partner partner4 = new Partner("4-client", "https://jl2022.fr");
        Partner partner5 = new Partner("5-client", "https://www.facebook.com/people/Les-fromages-à-DUDUL/100031928752636/");
        Partner partner6 = new Partner("6-client", "https://www.msn.com/fr-fr");

        this.allTheElements = List.of(partner1, partner2, partner3, partner4, partner5, partner6);
    }

    private static PartnerRepository getInstance()
    {
        if(instance == null) {
            instance = new PartnerRepository();
        }
        return instance;
    }
    public static List<Partner> findAll()
    {
        return PartnerRepository.getInstance().allTheElements;
    }

    public static Partner findOne(int id)
    {
        return PartnerRepository.getInstance().allTheElements.get(id);
    }
}