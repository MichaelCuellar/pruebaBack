package com.michael.cuellar.harry.potter.tiendaharry.repository.carShop.impl;

import com.michael.cuellar.harry.potter.tiendaharry.models.entity.CarShop;
import com.michael.cuellar.harry.potter.tiendaharry.models.entity.User;
import com.michael.cuellar.harry.potter.tiendaharry.repository.carShop.ICarShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class CarShopImpl implements ICarShopFacade{

    @Autowired
    private ICarShopRepository iCarShopRepository;

    @Override
    public Boolean addCarShop(CarShop carShop) {
        return !ObjectUtils.isEmpty(iCarShopRepository.save(carShop));
    }

    @Override
    public CarShop findCarShop(Long user) {
        return iCarShopRepository.findCarShopByUser(user);
    }

    @Override
    public void deleteByIdCar(Long idCar) {
        iCarShopRepository.deleteById(idCar);
    }
}
