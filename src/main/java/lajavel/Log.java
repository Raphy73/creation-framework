package lajavel;

import org.slf4j.Logger;

public final class Log { // Comme elle est finale on peut plus l'instancier

    private enum Level {
        DEBUG(3),
        INFO(2),
        WARN(1),
        ERROR(0);

        public final int level;

        Level(int level) {
            this.level = level;
        }
    }

    private static Log instance;
    private final Logger logger;

    private Log() {
        this.logger = org.slf4j.LoggerFactory.getLogger("Lajavel");
    }

    private static Log getInstance()
    {
        if(instance == null) {
            instance = new Log();
        }
        return instance;
    }

    public static void debug(String message)
    {
        print(Level.DEBUG, message);
    }

    public static void info(String message)
    {
        print(Level.INFO, message);
    }

    public static void error(String message)
    {
        print(Level.ERROR, message);
    }

    public static void warn(String message)
    {
        print(Level.WARN, message);
    }

    public static void print(Level level, String message) {
        int applicationLevel = Application.mode.level;

        System.out.println(applicationLevel);

        switch (level) {
            case DEBUG:
                if(applicationLevel >= Level.DEBUG.level) {
                    getInstance().logger.debug(message);
                }
            case INFO:
                if(applicationLevel >= Level.INFO.level) {
                    getInstance().logger.info(message);
                }
            case ERROR:
                if(applicationLevel >= Level.ERROR.level) {
                    getInstance().logger.error(message);
                }
            case WARN:
                if(applicationLevel >= Level.WARN.level) {
                    getInstance().logger.warn(message);
                }
                break;
        }
    }
}