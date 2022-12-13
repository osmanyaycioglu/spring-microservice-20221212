package com.training.inno.ms.customer.services.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;

@Getter
@Setter
@ToString
public class Customer {
    private String name;
    private String surname;
    private String username;
    private String password;
    private Integer height;
    private Integer weight;
    private String details;
    private ECustomerStatus customerStatus;
}
