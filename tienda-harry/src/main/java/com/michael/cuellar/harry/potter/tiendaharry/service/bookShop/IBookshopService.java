package com.michael.cuellar.harry.potter.tiendaharry.service.bookShop;

import com.michael.cuellar.harry.potter.tiendaharry.commons.dto.CarShopDto;
import com.michael.cuellar.harry.potter.tiendaharry.models.entity.Book;

import java.util.List;

public interface IBookshopService {

    List<Book> index();

    Boolean sale(List<CarShopDto> carShopDtoS, String basic);

}
