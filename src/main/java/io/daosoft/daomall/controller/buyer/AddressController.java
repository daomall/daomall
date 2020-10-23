package io.daosoft.daomall.controller.buyer;

import io.daosoft.daomall.support.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("buyer/address")
@RequestMapping("buyer")
public class AddressController {

    @GetMapping("address")
    public Response<String> index() {
        return Response.succeed("address");
    }
}
