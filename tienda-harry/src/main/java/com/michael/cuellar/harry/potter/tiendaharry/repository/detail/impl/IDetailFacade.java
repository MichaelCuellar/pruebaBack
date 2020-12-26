package com.michael.cuellar.harry.potter.tiendaharry.repository.detail.impl;

import com.michael.cuellar.harry.potter.tiendaharry.models.entity.Detail;

public interface IDetailFacade {

    /**
     * Inserta informacion del detalle
     * @param detail
     * @return
     */
    Boolean insertDetail(Detail detail);
}
