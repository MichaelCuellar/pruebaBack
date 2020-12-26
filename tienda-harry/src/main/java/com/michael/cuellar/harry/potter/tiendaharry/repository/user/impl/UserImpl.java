package com.michael.cuellar.harry.potter.tiendaharry.repository.user.impl;

import com.michael.cuellar.harry.potter.tiendaharry.models.entity.User;
import com.michael.cuellar.harry.potter.tiendaharry.repository.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements IUserFacade{

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public User userDetail(Long idUser) {
        return iUserRepository.findById(idUser).orElse(null);
    }
}
