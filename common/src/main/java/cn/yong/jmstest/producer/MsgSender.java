package cn.yong.jmstest.producer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by yong on 2016/12/2.
 */
@Service
public class MsgSender {
    private static final Logger logger = LogManager.getLogger(MsgSender.class);

    @Resource
    private JmsTemplate jmsTemplate;

    public void sendMsg(final String text) {
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                try {
//                    logger.info("send msg -->" + text);
                    return session.createTextMessage(text);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
    }
}
