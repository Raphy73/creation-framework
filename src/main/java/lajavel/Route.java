package lajavel;

import io.javalin.http.Context;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class Route
{
    public static void register(HttpVerb httpVerb, String routeName, Class<?> controllerClass, String methodName)
    {
        switch (httpVerb) {
            case GET -> Application.server.get(routeName, context -> {
                InvokeController(context, controllerClass, methodName);
            });
            case POST -> Application.server.post(routeName, ctx -> {

            });
            case PUT -> Application.server.put(routeName, ctx -> {

            });
            case DELETE -> Application.server.delete(routeName, ctx -> {

            });
            case PATCH -> Application.server.patch(routeName, ctx -> {

            });
            case HEAD -> Application.server.head(routeName, ctx -> {

            });
        }
    }

    public static void InvokeController(Context context, Class<?> controllerClass, String methodName) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Response response = new Response(context); // On fait ça car on veut que l'utilisateur ne soit pas dépendant de Javalin.
        // Du coup on passe le contexte dans une classe que nous avons créé (Response) comme çe le dev qui crééra un controller aura Response dans ses dépendances et non Javalin.

        Controller controller = (Controller) controllerClass.getDeclaredConstructor().newInstance();
        Method method = controller.getClass().getMethod(methodName, Response.class);
        method.setAccessible(true);
        method.invoke(controller, response);
    }
}