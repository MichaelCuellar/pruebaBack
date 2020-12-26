package com.michael.cuellar.harry.potter.tiendaharry.repository.detail.impl;

import com.michael.cuellar.harry.potter.tiendaharry.models.entity.Detail;
import com.michael.cuellar.harry.potter.tiendaharry.repository.detail.IDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class DetailImpl implements IDetailFacade{

    @Autowired
    private IDetailRepository iDetailRepository;

    @Override
    public Boolean insertDetail(Detail detail) {
        return !ObjectUtils.isEmpty(iDetailRepository.save(detail));
    }
}
