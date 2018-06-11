import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.XMLLayout;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.XMLFormatter;

import static java.lang.Thread.sleep;


/**
 * Created by li on 2015/5/24.
 */

public class LoggerTest {

    private static Logger logger = Logger.getLogger(LoggerTest.class);

    public static void main(String[] args) throws InterruptedException {
        // 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
        // 记录error级别的信息
        logger.error("This is error message.");
    }
}