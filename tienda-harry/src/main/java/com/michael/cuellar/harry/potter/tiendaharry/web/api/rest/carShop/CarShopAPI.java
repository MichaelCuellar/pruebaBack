package com.michael.cuellar.harry.potter.tiendaharry.web.api.rest.carShop;

import com.michael.cuellar.harry.potter.tiendaharry.commons.request.AddCarShopDto;
import com.michael.cuellar.harry.potter.tiendaharry.commons.response.ResponseCarShop;
import com.michael.cuellar.harry.potter.tiendaharry.service.carShop.ICarShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class CarShopAPI {

    @Autowired
    private ICarShopService iCarShopService;

    @PostMapping(value = "/addCarShop")
    public Boolean login(@RequestBody AddCarShopDto addCarShopDto, @RequestHeader String basic){
        return iCarShopService.addCarShop(addCarShopDto,basic);
    }

    @GetMapping(value = "/carShop")
    public ResponseCarShop findCarShop(@RequestHeader String basic){
        return iCarShopService.findCarShop(basic);
    }

    @DeleteMapping(value = "/deleteDetail/{id}")
    public Boolean deleteDetail(@PathVariable Long id){
        return iCarShopService.deleteDetail(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Boolean deleteCarShop(@PathVariable Long id){
        return iCarShopService.deleteCarByID(id);
    }

}
