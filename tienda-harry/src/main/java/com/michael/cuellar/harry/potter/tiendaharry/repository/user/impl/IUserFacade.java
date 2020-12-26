package com.michael.cuellar.harry.potter.tiendaharry.repository.user.impl;

import com.michael.cuellar.harry.potter.tiendaharry.models.entity.User;

public interface IUserFacade {

    /**
     * Devuelve la informacion del usuario
     * @param idUser
     * @return
     */
    User userDetail(Long idUser);
}
