package com.newtouch.rtip.configserver.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/")
public class SourceController {

    public static final Logger LOGGER = LoggerFactory.getLogger(SourceController.class);

    @ResponseBody
    @RequestMapping(path = "", method = RequestMethod.GET)
    public Object list(String username, String password) throws Exception {
        return null;
    }
}
