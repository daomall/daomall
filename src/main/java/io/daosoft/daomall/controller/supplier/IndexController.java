package io.daosoft.daomall.controller.supplier;

import io.daosoft.daomall.support.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("supplier/index")
@RequestMapping("supplier")
public class IndexController {

    @GetMapping("dashboard")
    public Response<String> index() {
        return Response.succeed("supplier dashboard");
    }
}
