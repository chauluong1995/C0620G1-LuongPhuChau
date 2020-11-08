package com.codegym.service.serviceFurama;

import com.codegym.entity.serviceFurama.RentType;
import com.codegym.entity.serviceFurama.ServiceFurama;
import com.codegym.entity.serviceFurama.ServiceType;

import java.util.List;

public interface ServiceFuramaService {
    List<ServiceFurama> allService();

    List<RentType> allRentType();

    List<ServiceType> allServiceType();

    void save(ServiceFurama serviceFurama);
}
