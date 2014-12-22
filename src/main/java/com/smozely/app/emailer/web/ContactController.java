package com.smozely.app.emailer.web;

import com.smozely.app.emailer.integration.ContactGateway;
import com.smozely.si.json.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.smozely.si.json.Response.OK;

@RestController
public class ContactController {

    private static final Logger LOG = LoggerFactory.getLogger(ContactController.class);

    private ContactGateway gateway;

    @Autowired
    public ContactController(ContactGateway gateway) {
        this.gateway = gateway;
    }

    @RequestMapping(value = "contact", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Response contact(@RequestBody ContactForm form) {
        LOG.info("Contact Request");
        gateway.send(form);
        return OK();
    }

}
