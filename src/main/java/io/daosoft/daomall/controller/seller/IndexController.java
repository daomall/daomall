package io.daosoft.daomall.controller.seller;

import io.daosoft.daomall.support.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("seller/index")
@RequestMapping("seller")
public class IndexController {

    @GetMapping("dashboard")
    public Response<String> index() {
        return Response.succeed("seller dashboard");
    }
}
