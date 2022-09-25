package api.mapper

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
class CustomerMapperTest {
    @Autowired
    lateinit var mapper: CustomerMapper

    @Test
    fun findById(){
        println(mapper.findById("1"))
    }

}