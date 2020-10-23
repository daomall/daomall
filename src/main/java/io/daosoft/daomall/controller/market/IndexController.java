package io.daosoft.daomall.controller;

import io.daosoft.daomall.support.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/")
    public Response<String> index() {
        return Response.succeed("home");
    }
}
