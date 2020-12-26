package com.michael.cuellar.harry.potter.tiendaharry.service.carShop;

import com.michael.cuellar.harry.potter.tiendaharry.commons.dto.CarShopDto;
import com.michael.cuellar.harry.potter.tiendaharry.commons.dto.UserBasicDto;
import com.michael.cuellar.harry.potter.tiendaharry.commons.request.AddCarShopDto;
import com.michael.cuellar.harry.potter.tiendaharry.commons.response.ResponseCarShop;
import com.michael.cuellar.harry.potter.tiendaharry.commons.utils.Util;
import com.michael.cuellar.harry.potter.tiendaharry.models.entity.CarShop;
import com.michael.cuellar.harry.potter.tiendaharry.models.entity.DetailCarShop;
import com.michael.cuellar.harry.potter.tiendaharry.models.entity.User;
import com.michael.cuellar.harry.potter.tiendaharry.repository.carShop.impl.ICarShopFacade;
import com.michael.cuellar.harry.potter.tiendaharry.repository.detailcarShop.impl.IDetailCarShopFacade;
import com.michael.cuellar.harry.potter.tiendaharry.repository.user.impl.IUserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarShopServiceImpl implements ICarShopService{

    @Autowired
    private ICarShopFacade iCarShopFacade;

    @Autowired
    private IUserFacade iUserFacade;

    @Autowired
    private IDetailCarShopFacade iDetailCarShopFacade;

    @Override
    public Boolean addCarShop(AddCarShopDto addCarShopDto,String basic) {
        UserBasicDto userBasicDto = Util.decodeBasic(basic);
        User user = iUserFacade.userDetail(userBasicDto.getIdUser());
        CarShop carShopTMP = iCarShopFacade.findCarShop(user.getIdUser());
        List<DetailCarShop> detailCarShopsList = new ArrayList<>();
        DetailCarShop detailCarShop = new DetailCarShop();
        if(!ObjectUtils.isEmpty(carShopTMP)){
            boolean status = true;
            for (int i=0; i<carShopTMP.getDetailCarShops().size(); i++){
                if(carShopTMP.getDetailCarShops().get(i).getBook().getIdBook() == addCarShopDto.getBook().getIdBook()){
                    carShopTMP.getDetailCarShops().get(i).setQuantity(addCarShopDto.getQuantity());
                    status = false;
                }
            }
            if(status){
                detailCarShop.setCarShop(carShopTMP);
                detailCarShop.setQuantity(addCarShopDto.getQuantity());
                detailCarShop.setBook(addCarShopDto.getBook());
                detailCarShopsList.add(detailCarShop);

                carShopTMP.getDetailCarShops().add(detailCarShop);
                carShopTMP.setUser(user);
            }
            return iCarShopFacade.addCarShop(carShopTMP);
        }else {
            CarShop carShop = new CarShop();
            detailCarShop.setCarShop(carShop);
            detailCarShop.setQuantity(addCarShopDto.getQuantity());
            detailCarShop.setBook(addCarShopDto.getBook());
            detailCarShopsList.add(detailCarShop);

            carShop.setDetailCarShops(detailCarShopsList);
            carShop.setUser(user);

            return iCarShopFacade.addCarShop(carShop);
        }
    }

    @Override
    public ResponseCarShop findCarShop(String basic) {
        UserBasicDto userBasicDto = Util.decodeBasic(basic);
        User user = iUserFacade.userDetail(userBasicDto.getIdUser());
        CarShop carShopTMP = iCarShopFacade.findCarShop(user.getIdUser());

        ResponseCarShop responseCarShop = new ResponseCarShop();
        List<CarShopDto> carShopDtoS = new ArrayList<>();
        if(carShopTMP != null){
            for (DetailCarShop detailCarShop: carShopTMP.getDetailCarShops()) {

                CarShopDto carShopDto = new CarShopDto();
                carShopDto.setBook(detailCarShop.getBook());
                carShopDto.setQuantity(detailCarShop.getQuantity());
                carShopDto.setIdDetailCarShop(detailCarShop.getIdDetailCarShop());
                carShopDto.setIdCarShop(carShopTMP.getIdCarShop());
                carShopDtoS.add(carShopDto);
            }
            responseCarShop.setCarShopDtoS(carShopDtoS);
            return responseCarShop;
        }else {
            return new ResponseCarShop();
        }
    }

    @Override
    public Boolean deleteDetail(Long idDetail) {
        iDetailCarShopFacade.deleteDetail(idDetail);
        return true;
    }

    @Override
    public Boolean deleteCarByID(Long idCar) {
        iCarShopFacade.deleteByIdCar(idCar);
        return true;
    }

}
