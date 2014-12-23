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

    @Value("${message.fromAddress}")
    private String emailDestination;

    @Autowired
    public ContactEndpoint(AmazonSESMessageSender sender) {
        this.sender = sender;
    }

    @Transformer(inputChannel = "contactChannel", outputChannel = "emailChannel", poller = @Poller())
    public SendEmailRequest transform(ContactForm form) {
        SendEmailRequest request = new SendEmailRequest()
                .withSource(emailSource)
                .withDestination(new Destination().withToAddresses(emailDestination))
                .withMessage(
                        new Message()
                                .withSubject(new Content().withData("New Contact Message From : " + form.getEmail()))
                                .withBody(new Body().withText(
                                        new Content().withData(
                                                    "--- \n"
                                                    + form.getEmail()
                                                    + "\n---\n"
                                                    + form.getSubject()
                                                    + "\n---\n"
                                                    + form.getMessage()
                                        ))));
        return request;
    }

    @ServiceActivator(inputChannel = "emailChannel")
    public void send(SendEmailRequest request) {
        sender.send(request);
    }

}
