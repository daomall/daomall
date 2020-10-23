package io.daosoft.daomall.controller.reseller;

import io.daosoft.daomall.support.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("reseller/index")
@RequestMapping("reseller")
public class IndexController {

    @GetMapping("dashboard")
    public Response<String> index() {
        return Response.succeed("reseller dashboard");
    }
}
