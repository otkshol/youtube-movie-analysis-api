package api.controller

import api.model.Customer
import api.service.CustomerService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customers")
class CustomerController (val customerService: CustomerService){

    @GetMapping("/hello")
    fun hello(): String {
        return "Hello World";
    }

    @PostMapping
    fun create(@RequestBody customer:Customer):Customer?{
        println("customer")
        println(customer.id)
        println(customer.username)
        return customerService.create(customer)
    }
}