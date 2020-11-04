package com.codegym.config;

import com.codegym.entity.customer.CustomerType;
import com.codegym.repository.CustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private CustomerTypeRepository customerTypeRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        List<String> customerTypeList = new ArrayList<>();
        customerTypeList.add("Diamond");
        customerTypeList.add("Platinum");
        customerTypeList.add("Gold");
        customerTypeList.add("Silver");
        customerTypeList.add("Member");

        for (String element : customerTypeList) {
            CustomerType customerType = new CustomerType();
            customerType.setName(element);
            customerTypeRepository.save(customerType);
        }
    }
}
