package app;

import lajavel.Controller;
import lajavel.Person;
import lajavel.Response;
import lajavel.View;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class IndexController extends Controller {
    public void index(Response response) throws NoSuchFieldException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Person person1 = new Person("Rapha", "Beaudet");
        Person person2 = new Person("Sam", "Trcz");

        response.context.html(
                View.make("index",
                        Map.entry("person1", person1),
                        Map.entry("person2", person2))
        );
    }
}