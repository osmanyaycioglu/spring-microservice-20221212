package com.training.inno.ms.customer.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.inno.ms.customer.rest.mappers.ICustomerMapper;
import com.training.inno.ms.customer.rest.models.CustomerRest;
import com.training.inno.ms.customer.services.CustomerManagementService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customer/provision")
public class CustomerProvisionController {

    @Autowired
    private CustomerManagementService customerManagementService;

//    @PostMapping("/do/{operation}")
//    public ResponseEntity<?> doAll(@PathVariable("operation")  String operation,
//                                   HttpServletRequest httpServletRequestParam) throws Exception {
//        switch (operation){
//            case "add":
//                ServletInputStream inputStream = httpServletRequestParam.getInputStream();
//                ObjectMapper objectMapper = new ObjectMapper();
//                CustomerRest customerRest = objectMapper.readValue(inputStream,
//                                                                   CustomerRest.class);
//                return ResponseEntity.ok("OK");
//        }
//        return ResponseEntity.ok("OK");
//    }


    @PostMapping("/add")
    @Operation(summary = "add new Customer", description = "Add new Customer to System")
    public String add(@RequestBody @Valid CustomerRest customerParam) {
        customerManagementService.add(ICustomerMapper.customerMapper.toCustomer(customerParam));
        return "OK";
    }

    @GetMapping("/disable")
    public String disable(@RequestParam("cid") Long customerId) {
        return "OK";
    }

    @GetMapping("/suspend")
    public String suspend(@RequestParam("cid") Long customerId) {
        return "OK";

    }

    @GetMapping("/enable")
    public String enable(@RequestParam("cid") Long customerId) {
        return "OK";

    }
}
