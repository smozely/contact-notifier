package com.smozely.app.emailer.integration;

import com.smozely.app.emailer.web.ContactForm;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway(defaultRequestChannel = "contactChannel")
public interface ContactGateway {

    public void send(ContactForm form);

}
