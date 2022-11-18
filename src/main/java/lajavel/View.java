package lajavel;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class View
{
    public static String make(String viewName, Map.Entry<String, Object>... entries) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        String rawHtml = View.getViewContentFromName(viewName);
        Matcher matcher = Pattern.compile("\\{\\{(.*?)\\}\\}").matcher(rawHtml);

        // Creating the target string buffer
        StringBuffer sb = new StringBuffer();

        while (matcher.find()) {
            String rawStringOfAnObject = matcher.group(1).replaceAll("\\s", ""); // Remove space
            String[] objectAndProperty = rawStringOfAnObject.split("\\."); // split by dot

            String objectName = objectAndProperty[0]; // Dans le HTML on a {{toto.title}} => toto
            String propertyOrMethodName = objectAndProperty[1]; // Dans le HTML on a {{toto.title}} => title

            for (Map.Entry<String, Object> entry : entries) {
                if(entry.getKey().equals(objectName)) {
                    matcher.appendReplacement(sb, getValueOf(propertyOrMethodName, entry.getValue()));
                    break;
                }
            }
        }

        matcher.appendTail(sb);

        StringBuffer sb2 = new StringBuffer();
        Matcher cssMatcher = Pattern.compile("\\{%(.*?)%\\}").matcher(sb.toString());

        while (cssMatcher.find()) {
            String cssFile = cssMatcher.group(1).replaceAll("\\s", ""); // Remove space
            cssMatcher.appendReplacement(sb2, "/template/assets/" + cssFile + ".css");
        }

        cssMatcher.appendTail(sb2);

        return sb2.toString();
    }

    private static String getViewContentFromName(String viewName)
    {
        URL resource = View.class.getClassLoader().getResource("views/" + viewName + ".javel");

        if (resource == null) {
            throw new RuntimeException("file" + viewName + " not found!"); // On fait planter le programme directement.
        }

        try {
            return Files.readString(Path.of(resource.toURI()), StandardCharsets.UTF_8);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException();
        }
    }

    public static String getValueOf(String propertyOrMethodName, Object object)
    {
        if(propertyOrMethodName.contains("()")) { // Si c'est une méthode
            String nameOfTheMethodWithoutParenthesis = propertyOrMethodName.replace("()", "");
            return getMethod(object, nameOfTheMethodWithoutParenthesis);
        } else {
            return getProperty(object, propertyOrMethodName);
        }
    }

    public static String getProperty(Object obj, String property)
    {
        String returnValue = "";

        try {
            Field field = obj.getClass().getDeclaredField(property); // getMethod doit avoir le nom de la méthode sans les parenthèses !
            field.setAccessible(true);
            returnValue = field.get(obj).toString();
        }
        catch (Exception e) {

        }

        return returnValue;
    }

    public static String getMethod(Object obj, String methodName)
    {
        String returnValue = null;

        try {
            Method method = obj.getClass().getMethod(methodName); // getMethod doit avoir le nom de la méthode sans les parenthèses !
            method.setAccessible(true);
            returnValue = method.invoke(obj).toString();
        }
        catch (Exception e) {

        }

        return returnValue;
    }
}