package utility;


import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Created by ПК on 06.06.2017.
 */
public class Log {

    private static Logger Log;

    static {
        Log = Logger.getLogger(Log.class.getName());
        DOMConfigurator.configure("log4j.xml");
    }

    public static void startTestCase(String sTestCaseName) {
        Log.info("----------------------------------------------------------------------------------------");
        Log.info("$$$$$$$$$$$$$$$$$$$$$   START     " + sTestCaseName + "       $$$$$$$$$$$$$$$$$$$$$$$$$");
        Log.info("----------------------------------------------------------------------------------------");
    }
    public static void endTestCase() {
        Log.info("-----------------------           " + "--- END ---" + "       --------------------------");
    }

    public static void info(String message) {
        Log.info(message);
    }

    public static void warn(String message) {
        Log.warn(message);
    }

    public static void error(String message) {
        Log.error(message);
    }

    public static void fatal(String message) {
        Log.fatal(message);
    }

    public static void debug(String message) {
        Log.debug(message);
    }
}