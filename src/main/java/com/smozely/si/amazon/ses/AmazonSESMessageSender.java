package com.smozely.si.amazon.ses;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AmazonSESMessageSender {

    private static final Logger LOG = LoggerFactory.getLogger(AmazonSESMessageSender.class);

    private final AmazonSimpleEmailService service;

    @Autowired
    public AmazonSESMessageSender(AmazonSimpleEmailService service) {
        this.service = service;
    }

    public void send(SendEmailRequest request) {
        LOG.info("Sending Mail Request");
        service.sendEmail(request);
        LOG.info("Mail Request Sent");
    }

}
