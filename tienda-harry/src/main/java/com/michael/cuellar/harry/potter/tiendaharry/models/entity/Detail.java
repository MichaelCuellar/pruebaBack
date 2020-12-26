package com.michael.cuellar.harry.potter.tiendaharry.models.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detail")
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detail")
    private Long idDetail;
    private Long quantity;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_SALE", nullable = false)
    private Sale sale;
    @ManyToOne()
    private Book book;
}
