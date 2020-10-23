package io.daosoft.daomall.controller.store;

import io.daosoft.daomall.support.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("store/index")
@RequestMapping("store")
public class IndexController {

    @GetMapping("dashboard")
    public Response<String> index() {
        return Response.succeed("store dashboard");
    }
}
