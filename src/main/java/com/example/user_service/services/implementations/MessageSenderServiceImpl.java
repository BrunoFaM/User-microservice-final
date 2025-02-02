package com.example.user_service.services.implementations;

import com.example.user_service.dtos.UserDTO;
import com.example.user_service.services.MessageSenderService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MessageSenderServiceImpl implements MessageSenderService {

    //private static final Logger logger = Logger.getLogger(MessageSenderServiceImpl.class.getName());
    private static final Logger logger = LoggerFactory.getLogger(MessageSenderServiceImpl.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendSuccessfulRegisterMessage(UserDTO user) {
        try{
            System.out.println("Inside sendSuccessfulRegisterMessage");
            amqpTemplate.convertAndSend("exchange", "routing.key6", user);
        } catch (AmqpException e) {
            logger.warn("RABBIT ALERT:" ,e.getMessage());
        }

    }
}
