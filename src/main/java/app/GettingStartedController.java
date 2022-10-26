package app;

import lajavel.Controller;
import lajavel.Response;
import lajavel.View;

import java.lang.reflect.InvocationTargetException;

public class GettingStartedController extends Controller {
    public void index(Response response) throws NoSuchFieldException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        response.context.html(
                View.make("started")
        );
    }
}
