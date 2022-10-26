package app.Repository;

import app.Model.Partner;

import java.util.ArrayList;
import java.util.List;

public final class PartnerRepository {
    private static PartnerRepository instance;
    public static List<Partner> allTheElements;

    private PartnerRepository()
    {
        allTheElements = new ArrayList<>();
    }

    private static PartnerRepository getInstance()
    {
        if(instance == null) {
            instance = new PartnerRepository();
        }
        return instance;
    }

    public static void add(Partner partner)
    {
        allTheElements.add(partner);
    }

    public static List<Partner> findAll()
    {
        return allTheElements;
    }
}
