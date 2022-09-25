package api.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController {

    @GetMapping("/hello")
    fun hello(): String {
        return "Hello World";
    }
}