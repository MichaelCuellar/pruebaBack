package com.michael.cuellar.harry.potter.tiendaharry.commons.response;

import com.michael.cuellar.harry.potter.tiendaharry.commons.dto.CarShopDto;
import lombok.*;

import java.util.List;
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCarShop {

    private List<CarShopDto> carShopDtoS;
}
