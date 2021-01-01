package ch05;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;

public class Ch05_15 {
    static Logger logger;
    static {
        logger = Logger.getLogger(Ch05_15.class.getName());
        try {
            Handler handler = new FileHandler("./.test/outlog.html");
            handler.setFormatter(new Formatter() {
                @Override
                public String format(LogRecord logRecord) {
                    String time = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSS").format(new Date(logRecord.getMillis()));

                    return String.format("<p>%s [%s] %s %s : %s</p>",
                            time,
                            logRecord.getLevel().getName(),
                            logRecord.getSourceClassName(),
                            logRecord.getSourceMethodName(),
                            logRecord.getMessage()
                    );
                }
            });
            logger.addHandler(handler);
            logger.setUseParentHandlers(false);
        } catch (Exception ex) {}
    }

    public static void main(String[] args) {
        logger.info("Hello");
        logger.info("World");
    }
}
