package app.Controller;

import app.Model.Partner;
import app.Repository.PartnerRepository;
import lajavel.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class IndexController extends Controller {
    public void index(Response response) throws NoSuchFieldException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        List partners = PartnerRepository.findAll();

        response.context.html(
                View.make("index",
                        Map.entry("partner1", partners.get(0)),
                        Map.entry("partner2", partners.get(1)),
                        Map.entry("partner3", partners.get(2)),
                        Map.entry("partner4", partners.get(3)),
                        Map.entry("partner5", partners.get(4)),
                        Map.entry("partner6", partners.get(5)))
        );
    }
}