package com.training.inno.ms.customer.tryout.rest;

import com.training.inno.ms.customer.rest.models.CustomerRest;
import org.springframework.web.bind.annotation.*;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/greetings")
public class GreetingsController {

    //@RequestMapping(value = "/hello1",method = RequestMethod.GET)
    // /greetings/hello1 - GET
    @GetMapping("/hello1")
    public String hello1() {
        return "hello1";
    }

    // /greetings/hello2 - GET
    @GetMapping("/hello2")
    public String hello2() {
        return "hello2";
    }

    // /greetings/hello2 - GET
    @PostMapping("/hello2")
    public String hello2a() {
        return "hello2 POSt";
    }


    @GetMapping("/hello3/{abc}/{xyz}")
    public String hello3(@PathVariable("abc") String name,
                         @PathVariable("xyz") String surname) {
        return "hello3 " + name + " " + surname;
    }

    @GetMapping("/hello4/{name}/{surname}")
    public String hello4(@PathVariable String name,
                         @PathVariable String surname) {
        return "hello4 " + name + " " + surname;
    }


    // /greetings/hello5?abc=osman&xyz=yaycıoğlu
    @GetMapping("/hello5")
    public String hello5(@RequestParam("abc") String name,
                         @RequestParam("xyz") String surname) {
        return "hello5 " + name + " " + surname;
    }

    // /greetings/hello6/osman?xyz=yaycıoğlu
    @GetMapping("/hello6/{abc}")
    public String hello6(@PathVariable("abc") String name,
                         @RequestParam("xyz") String surname) {
        return "hello6 " + name + " " + surname;
    }

    @PostMapping("/hello7")
    public String hello7(@RequestBody CustomerRest customerParam) {
        return "hello7 " + customerParam;
    }


}
