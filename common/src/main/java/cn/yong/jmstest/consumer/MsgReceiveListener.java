package cn.yong.jmstest.consumer;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@Service
public class MsgReceiveListener implements MessageListener {

    private static final Logger logger = LogManager.getLogger(MsgReceiveListener.class);

    @Override
    public void onMessage(Message message) {
        try {
            String text = "receive msg ----->" + message.getJMSMessageID();
            if (message instanceof ActiveMQTextMessage) {
                ActiveMQTextMessage msg = (ActiveMQTextMessage) message;
                text += msg.getText();
            }
            logger.info(text);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
