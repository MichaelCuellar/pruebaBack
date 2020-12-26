package com.michael.cuellar.harry.potter.tiendaharry.commons.dto;

import com.michael.cuellar.harry.potter.tiendaharry.models.entity.Book;
import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CarShopDto {

    private Long quantity;
    private Book book;
    private Long idDetailCarShop;
    private Long idCarShop;
}
