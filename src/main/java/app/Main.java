package app;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.util.Map;
import lajavel.*;

public class Main {
    public static void main(String[] args) throws URISyntaxException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, IOException // Une classe statique ne peut pas être instanciée.
    {
        Application app = Application.start(7071, Application.Mode.DEVELOPMENT);

        Route.register(HttpVerb.GET, "/", IndexController.class, "index");
        Route.register(HttpVerb.GET, "/contributeurs", ContributorController.class, "index");
        Route.register(HttpVerb.GET, "/start", GettingStartedController.class, "index");
    }
}