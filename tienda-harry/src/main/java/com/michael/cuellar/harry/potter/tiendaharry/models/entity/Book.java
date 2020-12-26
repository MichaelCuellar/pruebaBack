package com.michael.cuellar.harry.potter.tiendaharry.models.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @Column(name = "id_book")
    private Long idBook;
    private String title;
    private Long price;
    private Long units;
    private String img;
}
