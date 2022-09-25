package api.mapper

import api.model.Customer
import org.apache.ibatis.annotations.Mapper

@Mapper
interface CustomerMapper {
   fun create(customer: Customer)
   fun findById(id: String):Customer?
}