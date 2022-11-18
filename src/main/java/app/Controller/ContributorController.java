package app.Controller;

import app.Repository.ContributorRepository;
import lajavel.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class ContributorController extends Controller {
    public void index(Response response) throws NoSuchFieldException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        List contributors = ContributorRepository.findAll();

        response.context.html(
                View.make("contributors",
                        Map.entry("contributor1", contributors.get(0)),
                        Map.entry("contributor2", contributors.get(1)),
                        Map.entry("contributor3", contributors.get(2)),
                        Map.entry("contributor4", contributors.get(3)))
        );
    }
}
