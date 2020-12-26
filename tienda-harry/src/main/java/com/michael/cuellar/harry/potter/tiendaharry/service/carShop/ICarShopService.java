package com.michael.cuellar.harry.potter.tiendaharry.service.carShop;

import com.michael.cuellar.harry.potter.tiendaharry.commons.request.AddCarShopDto;
import com.michael.cuellar.harry.potter.tiendaharry.commons.response.ResponseCarShop;


public interface ICarShopService {

    Boolean addCarShop(AddCarShopDto addCarShopDto,String basic);

    ResponseCarShop findCarShop(String basic);

    Boolean deleteDetail(Long idDetail);

    Boolean deleteCarByID(Long idCar);
}
