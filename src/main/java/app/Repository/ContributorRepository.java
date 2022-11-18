package app.Repository;

import app.Model.Contributor;

import java.util.List;

public class ContributorRepository {
    private static ContributorRepository instance;
    private final List<Contributor> allTheElements;

    private ContributorRepository()
    {
        Contributor contributor1 = new Contributor("Raphaël", "Beaudet", "https://www.raphaelbeaudet.fr/wp-content/uploads/2020/10/photo_raphael_beaudet.jpeg", "CEO", "Creator of the Laravel project", "https://twitter.com/raphaelbeaudet");
        Contributor contributor2 = new Contributor("Tim", "Cook", "https://www.lesmobiles.com/img/actus/Tim-Cook-le-meilleur-patron-de-tous-les-temps-1650032190-large.jpg", "Project Manager", "He is responsible for coordinating the teams around the project", "https://twitter.com/tim_cook");
        Contributor contributor3 = new Contributor("Jeff", "Bezos", "https://cdn.futura-sciences.com/sources/images/Jeff%20bezos.jpg", "Investor", "Thanks to Jeff Bezos, Lajavel raised 20 million dollars", "https://twitter.com/jeffbezos");
        Contributor contributor4 = new Contributor("Marc", "Zuckerberg", "https://pbs.twimg.com/profile_images/1042510623962275840/1Iw_Mvud_400x400.jpg", "Full-stack developer", "He left Nuxt to integrate Lajavel", "https://twitter.com/Atinux?ref_src=twsrc%5Egoogle%7Ctwcamp%5Eserp%7Ctwgr%5Eauthor");

        this.allTheElements = List.of(contributor1, contributor2, contributor3, contributor4);
    }

    private static ContributorRepository getInstance()
    {
        if (instance == null) {
            instance = new ContributorRepository();
        }
        return instance;
    }

    public static Contributor findOne(int id)
    {
        return ContributorRepository.getInstance().allTheElements.get(id);
    }

    public static List<Contributor> findAll()
    {
        return ContributorRepository.getInstance().allTheElements;
    }
}
