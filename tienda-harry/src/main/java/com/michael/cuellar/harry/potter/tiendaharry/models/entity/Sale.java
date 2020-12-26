package com.michael.cuellar.harry.potter.tiendaharry.models.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sale")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idSale;
    private Calendar date;
    @ManyToOne ()
    @JoinColumn(name = "FK_USER", nullable = false)
    private User user;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "sale")
    private List<Detail> detailList;
}
