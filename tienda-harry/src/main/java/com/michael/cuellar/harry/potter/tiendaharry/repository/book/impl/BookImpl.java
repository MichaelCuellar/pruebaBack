package com.michael.cuellar.harry.potter.tiendaharry.repository.book.impl;

import com.michael.cuellar.harry.potter.tiendaharry.models.entity.Book;
import com.michael.cuellar.harry.potter.tiendaharry.repository.book.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class BookImpl implements IBookFacade{

    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public Boolean updateBook(Long idBook, Long quantitySale) {
        Book bookTMP = iBookRepository.findById(idBook).orElse(null);
        if (!ObjectUtils.isEmpty(bookTMP)) {
            bookTMP.setUnits(bookTMP.getUnits()-quantitySale);
            Book book = iBookRepository.save(bookTMP);
            return !ObjectUtils.isEmpty(book);
        }
        return false;
    }

    @Override
    public List<Book> index() {
        return iBookRepository.findAll();
    }

    @Override
    public Book findByID(Long idBook) {
        return iBookRepository.findById(idBook).orElse(null);
    }
}
