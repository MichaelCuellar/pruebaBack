package com.michael.cuellar.harry.potter.tiendaharry.service.bookShop;

import com.michael.cuellar.harry.potter.tiendaharry.commons.dto.CarShopDto;
import com.michael.cuellar.harry.potter.tiendaharry.commons.dto.UserBasicDto;
import com.michael.cuellar.harry.potter.tiendaharry.commons.utils.Util;
import com.michael.cuellar.harry.potter.tiendaharry.models.entity.Book;
import com.michael.cuellar.harry.potter.tiendaharry.models.entity.Detail;
import com.michael.cuellar.harry.potter.tiendaharry.models.entity.Sale;
import com.michael.cuellar.harry.potter.tiendaharry.models.entity.User;
import com.michael.cuellar.harry.potter.tiendaharry.repository.book.impl.IBookFacade;
import com.michael.cuellar.harry.potter.tiendaharry.repository.carShop.impl.ICarShopFacade;
import com.michael.cuellar.harry.potter.tiendaharry.repository.sale.impl.ISaleFacade;
import com.michael.cuellar.harry.potter.tiendaharry.repository.user.impl.IUserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class BookshopServiceImpl implements IBookshopService{

    @Autowired
    private IBookFacade iBookFacade;

    @Autowired
    private ISaleFacade iSaleFacade;

    @Autowired
    private IUserFacade iUserFacade;

    @Autowired
    private ICarShopFacade iCarShopFacade;

    @Override
    public List<Book> index() {
        return iBookFacade.index();
    }

    @Override
    public Boolean sale(List<CarShopDto> carShopDtoS, String basic) {
        for (CarShopDto tmp: carShopDtoS) {
            Book bookTMP = iBookFacade.findByID(tmp.getBook().getIdBook());
            if(bookTMP != null){
                if(tmp.getQuantity() > bookTMP.getUnits()){
                    return false;
                }
            }else{
                return false;
            }
        }
        UserBasicDto userBasicDto = Util.decodeBasic(basic);
        User user = iUserFacade.userDetail(userBasicDto.getIdUser());
        Sale sale = new Sale();

        List<Detail> detailList = new ArrayList<>();

        for (CarShopDto tmp: carShopDtoS) {
            Detail detail = new Detail();
            detail.setBook(tmp.getBook());
            detail.setQuantity(tmp.getQuantity());
            detail.setSale(sale);
            detailList.add(detail);
            iBookFacade.updateBook(tmp.getBook().getIdBook(),tmp.getQuantity());
        }

        sale.setUser(user);
        sale.setDetailList(detailList);
        sale.setDate(Calendar.getInstance());
        iCarShopFacade.deleteByIdCar(carShopDtoS.get(0).getIdCarShop());

        return iSaleFacade.addSale(sale);
    }

}
