package api.repository

import api.conifg.DbConfig
import org.junit.jupiter.api.Assertions.assertEquals

import api.mapper.CustomerMapper
import api.model.Customer
import org.dbunit.database.DatabaseConnection
import org.dbunit.database.IDatabaseConnection
import org.dbunit.dataset.IDataSet
import org.dbunit.dataset.csv.CsvDataSet
import org.dbunit.operation.DatabaseOperation
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.transaction.annotation.Transactional
import java.io.File
import javax.sql.DataSource

@SpringBootTest
@Transactional
class CustomerMapperTest(
    private val mapper: CustomerMapper,
    private val dbConfig: DbConfig,
) {
    lateinit var dbConnection: IDatabaseConnection
    lateinit var inputCsvDataSet: IDataSet

    /**
     * テストメソッド実行前にcleanとinsertを実施する
     */
    @BeforeEach
    fun setup(){
        dbConnection = DatabaseConnection(dbConfig.dataSource().connection)
        inputCsvDataSet = CsvDataSet(
            File("src/test/kotlin/api/repository")
        )
        DatabaseOperation.CLEAN_INSERT.execute(dbConnection, inputCsvDataSet)
    }

    /**
     * テストメソッド終了後にDB接続をCloseする
     */
    @AfterEach
    fun teardown(){
        dbConnection.close()
    }

    @DisplayName("INSERT Test: データのINSERTをテストする")
    @Test
    fun testInsert(){

        println("===================")
        println(dbConfig.dataSource().connection)
        println(dbConfig.username)
        println("===================")

        /**
         * Arrange
         */
        val requestCustomer = Customer(
            id = "100",
            username = "user100",
            email = "test.user.100@example.com",
            phoneNumber = "01234567890",
            postCode = "1234567"
        )

        /**
         * Act
         */
        val responseCustomer = mapper.create(requestCustomer)

        /**
         * Assert
         */
        assertEquals(requestCustomer,responseCustomer)
    }
}