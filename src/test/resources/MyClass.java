
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class MyClass {
    static Logger logger = LogManager.getLogger(MyClass.class);

    public void someMethod() {
        logger.info("This is an info log");
        logger.error("This is an error log");
    }
}
// This class uses Log4j to log messages at different levels.
