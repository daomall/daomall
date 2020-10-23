package io.daosoft.daomall.controller.buyer;

import io.daosoft.daomall.support.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("buyer/profile")
@RequestMapping("buyer/profile")
public class ProfileController {

    @GetMapping("get")
    public Response<String> index() {
        return Response.succeed("profile");
    }
}
