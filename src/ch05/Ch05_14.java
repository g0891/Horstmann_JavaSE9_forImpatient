package ch05;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class Ch05_14 {
    static Logger logger;
    static {
        logger = Logger.getLogger(Ch05_14.class.getName());
        Handler handler = new ConsoleHandler();
        Pattern pattern = Pattern.compile(".*(python|pascal|c\\+\\+).*", Pattern.CASE_INSENSITIVE);
        handler.setFilter(record -> !pattern.matcher(record.getMessage()).matches());
        logger.addHandler(handler);
        logger.setUseParentHandlers(false);
    }

    public static void main(String[] args) {
        logger.info("Hello, World!");
        logger.info("Python is good");
        logger.info("Pascal is old");
        logger.info("C++ is fast");
        logger.info("Good bye!");
    }
}
