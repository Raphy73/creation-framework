package app.Controller;

import app.Model.Partner;
import lajavel.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class IndexController extends Controller {
    public void index(Response response) throws NoSuchFieldException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Partner partner1 = new Partner("1-client", "http://www.boucherie-ayet-chambery.com");
        Partner partner2 = new Partner("2-client", "https://www.skyrock.com/blog/");
        Partner partner3 = new Partner("3-client", "https://www.alcatelmobile.com/fr/");
        Partner partner4 = new Partner("4-client", "https://jl2022.fr");
        Partner partner5 = new Partner("5-client", "https://www.facebook.com/people/Les-fromages-à-DUDUL/100031928752636/");
        Partner partner6 = new Partner("6-client", "https://www.msn.com/fr-fr");

        response.context.html(
                View.make("index",
                        Map.entry("partner1", partner1),
                        Map.entry("partner2", partner2),
                        Map.entry("partner3", partner3),
                        Map.entry("partner4", partner4),
                        Map.entry("partner5", partner5),
                        Map.entry("partner6", partner6))
        );
    }
}