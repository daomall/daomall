package io.daosoft.daomall.controller.socket;

import io.daosoft.daomall.support.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("socket/index")
@RequestMapping("socket")
public class IndexController {

    @GetMapping("dashboard")
    public Response<String> index() {
        return Response.succeed("socket dashboard");
    }
}
