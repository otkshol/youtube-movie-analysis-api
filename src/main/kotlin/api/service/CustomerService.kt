package api.service

import api.mapper.CustomerMapper
import api.model.Customer
import org.springframework.stereotype.Service

@Service
class CustomerService (private val customerMapper: CustomerMapper){
    fun create(customer: Customer): Customer? {
        customerMapper.create(customer)
        return customer
    }
}