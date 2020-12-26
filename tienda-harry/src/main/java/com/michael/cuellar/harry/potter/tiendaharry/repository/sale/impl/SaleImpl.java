package com.michael.cuellar.harry.potter.tiendaharry.repository.sale.impl;

import com.michael.cuellar.harry.potter.tiendaharry.models.entity.Sale;
import com.michael.cuellar.harry.potter.tiendaharry.repository.sale.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class SaleImpl implements ISaleFacade{

    @Autowired
    private ISaleRepository iSaleRepository;

    @Override
    public Boolean addSale(Sale sale) {
        return !ObjectUtils.isEmpty(iSaleRepository.save(sale));
    }
}
