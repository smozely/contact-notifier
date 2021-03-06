package com.smozely.app.emailer

import com.smozely.app.emailer.web.ContactForm
import spock.lang.Specification

import static org.assertj.core.api.Assertions.assertThat;

class ContactFormTest extends Specification {

    def "Exercise Contact form constructors and getters"() {

        when:
        ContactForm form = new ContactForm("email", "subject", "message")

        then:
        assertThat(form.getEmail()).isEqualTo("email")
        assertThat(form.getSubject()).isEqualTo("subject")
        assertThat(form.getMessage()).isEqualTo("message")
    }

}
