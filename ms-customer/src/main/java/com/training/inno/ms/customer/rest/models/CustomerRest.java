package com.training.inno.ms.customer.rest.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;

@Getter
@Setter
@ToString
public class CustomerRest {
    @NotEmpty
    @Size(min = 2,max = 15)
    private String name;
    @NotEmpty
    @Size(min = 2,max = 15)
    private String surname;
    private String username;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")
    private String password;
    @NotNull
    @Max(300)
    @Min(50)
    private Integer height;
    @NotNull
    @Max(300)
    @Min(50)
    private Integer weight;
}
