package com.smozely.app.emailer.integration;

import com.amazonaws.services.simpleemail.model.*;
import com.smozely.app.emailer.web.ContactForm;
import com.smozely.si.amazon.ses.AmazonSESMessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;

@MessageEndpoint
public class ContactEndpoint {

    private final AmazonSESMessageSender sender;
    @Value("${message.fromAddress}")
    private String emailSource;

    @Autowired
    public ContactEndpoint(AmazonSESMessageSender sender) {
        this.sender = sender;
    }

    @Transformer(inputChannel = "contactChannel", outputChannel = "emailChannel", poller = @Poller())
    public SendEmailRequest transform(ContactForm form) {
        SendEmailRequest request = new SendEmailRequest()
                .withSource(emailSource)
                .withDestination(new Destination().withToAddresses(form.getEmail()))
                .withMessage(
                        new Message()
                                .withSubject(new Content().withData(form.getSubject()))
                                .withBody(new Body().withText(new Content().withData(form.getMessage()))));
        return request;
    }

    @ServiceActivator(inputChannel = "emailChannel")
    public void send(SendEmailRequest request) {
        sender.send(request);
    }

}
