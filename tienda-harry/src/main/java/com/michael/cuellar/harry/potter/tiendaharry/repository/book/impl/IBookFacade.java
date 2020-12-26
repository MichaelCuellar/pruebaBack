package com.michael.cuellar.harry.potter.tiendaharry.repository.book.impl;

import com.michael.cuellar.harry.potter.tiendaharry.models.entity.Book;

import java.util.List;

public interface IBookFacade {

    /**
     * Actualizar la informacion del libro
     * @param idBook
     * @return
     */
    Boolean updateBook(Long idBook, Long quantitySale);

    /**
     * retorna todos los libros actuales
     * @return
     */
    List<Book> index();

    /**
     * Buscar libro
     * @param idBook
     * @return
     */
    Book findByID(Long idBook);
}
