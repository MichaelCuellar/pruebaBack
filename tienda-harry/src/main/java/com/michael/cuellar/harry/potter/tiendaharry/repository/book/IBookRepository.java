package com.michael.cuellar.harry.potter.tiendaharry.repository.book;

import com.michael.cuellar.harry.potter.tiendaharry.models.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book,Long> {
}
