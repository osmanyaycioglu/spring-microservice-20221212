package com.training.inno.ms.customer.rest.mappers;

import com.training.inno.ms.customer.rest.models.CustomerRest;
import com.training.inno.ms.customer.services.models.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ICustomerMapper {

    ICustomerMapper customerMapper = Mappers.getMapper(ICustomerMapper.class);

    Customer toCustomer(CustomerRest customerParam);

    CustomerRest toCustomerRest(Customer customerParam);

}
