package com.michael.cuellar.harry.potter.tiendaharry.web.api.rest.bookShop;

import com.michael.cuellar.harry.potter.tiendaharry.commons.dto.CarShopDto;
import com.michael.cuellar.harry.potter.tiendaharry.models.entity.Book;
import com.michael.cuellar.harry.potter.tiendaharry.service.bookShop.IBookshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class BookshopAPI {

    @Autowired
    private IBookshopService iBookshopService;

    @GetMapping(value = "/book")
    public List<Book> index(){
        return iBookshopService.index();
    }

    @PostMapping(value = "/sale")
    public Boolean sale(@RequestBody List<CarShopDto> carShopDtoList,@RequestHeader String basic ){
        return iBookshopService.sale(carShopDtoList,basic);
    };

}
