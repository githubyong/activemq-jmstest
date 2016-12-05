
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

/**
 * Created by Administrator on 2016/7/6 0006.
 */
public class Main {
    private static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"classpath:spring-root.xml"});
            logger.info("start ...");
            while (true) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
