package com.michael.cuellar.harry.potter.tiendaharry.commons.request;

import com.michael.cuellar.harry.potter.tiendaharry.models.entity.Book;
import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddCarShopDto {

    private Book book;
    private Long quantity;
}
