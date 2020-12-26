package com.michael.cuellar.harry.potter.tiendaharry.repository.sale;

import com.michael.cuellar.harry.potter.tiendaharry.models.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISaleRepository extends JpaRepository<Sale,Long> {
}
