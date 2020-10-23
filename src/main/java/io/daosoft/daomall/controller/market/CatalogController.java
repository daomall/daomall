package io.daosoft.daomall.controller;

import io.daosoft.daomall.support.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("catalog")
public class CatalogController {

    @GetMapping("list")
    public Response<String> index() {
        return Response.succeed("Catalog Lists");
    }
}
