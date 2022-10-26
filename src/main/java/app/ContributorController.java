package app;

import lajavel.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class ContributorController extends Controller {
    public void index(Response response) throws NoSuchFieldException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Contributor contributor1 = new Contributor("Raphaël", "Beaudet", "https://www.raphaelbeaudet.fr/wp-content/uploads/2020/10/photo_raphael_beaudet.jpeg", "CEO", "Creator of the Laravel project", "https://twitter.com/raphaelbeaudet");
        Contributor contributor2 = new Contributor("Tim", "Cook", "https://www.lesmobiles.com/img/actus/Tim-Cook-le-meilleur-patron-de-tous-les-temps-1650032190-large.jpg", "Project Manager", "He is responsible for coordinating the teams around the project", "https://twitter.com/tim_cook");
        Contributor contributor3 = new Contributor("Jeff", "Bezos", "https://cdn.futura-sciences.com/sources/images/Jeff%20bezos.jpg", "Investor", "Thanks to Jeff Bezos, Lajavel raised 20 million dollars", "https://twitter.com/jeffbezos");
        Contributor contributor4 = new Contributor("Marc", "Zuckerberg", "https://pbs.twimg.com/profile_images/1042510623962275840/1Iw_Mvud_400x400.jpg", "Full-stack developer", "He left Nuxt to integrate Lajavel", "https://twitter.com/Atinux?ref_src=twsrc%5Egoogle%7Ctwcamp%5Eserp%7Ctwgr%5Eauthor");

        response.context.html(
                View.make("contributors",
                        Map.entry("contributor1", contributor1),
                        Map.entry("contributor2", contributor2),
                        Map.entry("contributor3", contributor3),
                        Map.entry("contributor4", contributor4))
        );
    }
}
