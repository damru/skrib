package com.damienrubio.skrib.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by damien on 24/12/2016.
 */
@RestController
public class DefaultController {

    @RequestMapping(MappingConstants.INDEX)
    public String index() {
        return "skrib api backend";
    }

}
