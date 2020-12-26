package com.michael.cuellar.harry.potter.tiendaharry.models.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "car_shop")
public class CarShop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarShop;
    @OneToOne()
    @JoinColumn(name = "FK_USER", nullable = false)
    private User user;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "carShop")
    private List<DetailCarShop> detailCarShops;
}
