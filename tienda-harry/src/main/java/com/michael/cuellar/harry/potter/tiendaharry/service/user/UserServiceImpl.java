package com.michael.cuellar.harry.potter.tiendaharry.service.user;

import com.michael.cuellar.harry.potter.tiendaharry.models.entity.User;
import com.michael.cuellar.harry.potter.tiendaharry.repository.user.impl.IUserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserFacade iUserFacade;

    @Override
    public Boolean login(String basic) {

        byte[] userDetail = Base64.getDecoder().decode(basic);
        String userDecode = new String(userDetail);
        Long idUser = Long.valueOf(userDecode.split(":")[0]);
        String idCredentials = userDecode.split(":")[1];
        User user = iUserFacade.userDetail(idUser);
        if(user != null){
            return user.getCredentials().equals(idCredentials);
        }
        return false;
    }
}
