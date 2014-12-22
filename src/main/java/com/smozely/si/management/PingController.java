package com.smozely.si.management;

import com.smozely.si.json.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.smozely.si.json.Response.OK;

@RestController
public class PingController {

    @RequestMapping("/")
    public Response ping() {
        return OK("PONG!");
    }

}
