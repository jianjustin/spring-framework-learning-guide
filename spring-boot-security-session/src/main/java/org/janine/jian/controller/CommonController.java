package org.janine.jian.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommonController {
    @RequestMapping(method = RequestMethod.GET , value = "/test1")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String test1(){
        return "/test/test1.html";
    }

    @RequestMapping(method = RequestMethod.GET , value = "/test2")
    @PreAuthorize("hasAnyRole('MEMBER')")
    public String test2(){
        return "/test/test2.html";
    }
}
