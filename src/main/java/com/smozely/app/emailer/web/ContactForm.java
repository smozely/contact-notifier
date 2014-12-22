package com.smozely.app.emailer.web;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.google.common.base.Preconditions.checkNotNull;

public class ContactForm {

    private String email;

    private String subject;

    private String message;

    @JsonCreator
    public ContactForm(@JsonProperty("email") String email, @JsonProperty("subject") String subject, @JsonProperty("message") String message) {
        this.email = email;
        this.subject = checkNotNull(subject);
        this.message = checkNotNull(message);
    }

    public String getEmail() {
        return email;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

}
