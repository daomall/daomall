package io.daosoft.daomall.controller.admin;

import io.daosoft.daomall.support.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("admin/index")
@RequestMapping("admin")
public class IndexController {

    @GetMapping("dashboard")
    public Response<String> index() {
        return Response.succeed("admin dashboard");
    }
}
