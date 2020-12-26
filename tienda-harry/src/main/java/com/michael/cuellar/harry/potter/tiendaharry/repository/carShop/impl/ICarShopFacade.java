package com.michael.cuellar.harry.potter.tiendaharry.repository.carShop.impl;

import com.michael.cuellar.harry.potter.tiendaharry.models.entity.CarShop;


public interface ICarShopFacade {

    Boolean addCarShop(CarShop carShop);
    CarShop findCarShop(Long user);
    void deleteByIdCar(Long idCar);
}
