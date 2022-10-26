package lajavel;

import io.javalin.Javalin;

public final class Application { // On a créé un singleton ici !
    public enum Mode {
        DEVELOPMENT(3),
        TEST(1),
        PRODUCTION(0);

        public final int level;

        Mode(int level) {
            this.level = level;
        }
    }
    private static Application instance;
    public int port;
    public static Javalin server;
    public static Mode mode;

    private Application(int port, Mode mode)
    {
        this.port = port;
        this.server = Javalin.create().start(this.port);
        Application.mode = mode;
    }

    public static Application start(int port, Mode mode)
    {
        if(instance == null) {
            instance = new Application(port, mode); // On créé une nouvelle instance ici. Comme l'attribut "instance" est static, c'est lié à la classe !
        } else {
            throw new RuntimeException("Server already started");
        }
        return instance;
    }

    public static Application getInstance()
    {
        if(instance == null) {
            throw new RuntimeException("Application not started");
        }
        return instance;
    }
}