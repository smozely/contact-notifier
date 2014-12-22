package com.smozely.domain

import spock.lang.Specification

import javax.validation.ConstraintViolationException

class EmailAddressTest extends Specification {

    def "Can create an EmailAddress with valid email address"() {
        when:
        new EmailAddress("jimmy.crackedcorn@gmail.com")
        then:
        notThrown ConstraintViolationException
    }

    def "Can't create an EmailAddress with null"() {
        when:
        new EmailAddress(null)
        then:
        thrown ConstraintViolationException
    }

    def "Can't create an EmailAddress with invalid emails"() {
        when:
        new EmailAddress("Im Not An Email")
        then:
        thrown ConstraintViolationException
    }

}
