package com.michael.cuellar.harry.potter.tiendaharry.repository.user;

import com.michael.cuellar.harry.potter.tiendaharry.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Long> {
}
