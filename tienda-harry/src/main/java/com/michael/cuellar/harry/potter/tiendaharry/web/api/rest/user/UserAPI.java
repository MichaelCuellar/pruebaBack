package com.michael.cuellar.harry.potter.tiendaharry.web.api.rest.user;

import com.michael.cuellar.harry.potter.tiendaharry.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class UserAPI {

    @Autowired
    private IUserService iUserService;

    @GetMapping(value = "/login")
    public Boolean login(@RequestHeader String basic){
        return iUserService.login(basic);
    }
}
