package io.daosoft.daomall.controller.shop;

import io.daosoft.daomall.support.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("shop/index")
@RequestMapping("shop")
public class IndexController {

    @GetMapping("dashboard")
    public Response<String> index() {
        return Response.succeed("shop dashboard");
    }
}
