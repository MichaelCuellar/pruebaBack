package com.michael.cuellar.harry.potter.tiendaharry.commons.utils;

import com.michael.cuellar.harry.potter.tiendaharry.commons.dto.UserBasicDto;
import lombok.Data;

import java.util.Base64;

@Data
public class Util {

    public static UserBasicDto decodeBasic(String basic){
        byte[] userDetail = Base64.getDecoder().decode(basic);
        String userDecode = new String(userDetail);
        Long idUser = Long.valueOf(userDecode.split(":")[0]);
        String idCredentials = userDecode.split(":")[1];
        return new UserBasicDto().builder().idUser(idUser).credentials(idCredentials).build();

    }
}
