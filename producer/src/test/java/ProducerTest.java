import cn.yong.jmstest.producer.MsgSender;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yong on 2016/12/2.
 */
public class ProducerTest {
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"classpath:spring-root.xml"});
        MsgSender sender = ctx.getBean(MsgSender.class);
        while (true) {

            long beginTime = System.currentTimeMillis();
            System.out.println("Producer:->Sending message: ");

            for (int i = 0; i < 10000 * 5; i++) {
                String msg = " msg " + i;
                sender.sendMsg(msg);
                if ((i + 1) % 1000 == 0) {
                    long mid = System.currentTimeMillis();
                    System.out.println("This is the " + i + " message! time-cost=" + (mid - beginTime));
                    beginTime = System.currentTimeMillis();
                }
            }
        }
    }
}
