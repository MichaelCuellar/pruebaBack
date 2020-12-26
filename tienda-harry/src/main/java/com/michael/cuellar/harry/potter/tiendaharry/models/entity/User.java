package com.michael.cuellar.harry.potter.tiendaharry.models.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id_user")
    private Long idUser;
    private String name;
    private String credentials;
}
