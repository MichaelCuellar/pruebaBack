package com.michael.cuellar.harry.potter.tiendaharry.repository.detailcarShop.impl;

import com.michael.cuellar.harry.potter.tiendaharry.repository.detailcarShop.IDetailCarShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailCarShopImpl implements IDetailCarShopFacade{

    @Autowired
    private IDetailCarShopRepository iDetailCarShopRepository;
    @Override
    public void deleteDetail(Long idDetailCar) {
         iDetailCarShopRepository.deleteById(idDetailCar);
    }
}
