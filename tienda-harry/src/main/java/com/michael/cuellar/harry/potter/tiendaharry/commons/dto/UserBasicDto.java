package com.michael.cuellar.harry.potter.tiendaharry.commons.dto;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserBasicDto {
    private Long idUser;
    private String credentials;
}
