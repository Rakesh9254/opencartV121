package PageObjects;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class LoggerTest {
    static Logger logger = LogManager.getLogger(LoggerTest.class);

    public static void main(String[] args) {
        logger.debug("Debug message");
        logger.info("Info message");
        logger.warn("Warning message");
        logger.error("Error message");
        logger.fatal("Fatal message");
    }
}
// This is a simple Java class that demonstrates how to use Log4j for logging.
