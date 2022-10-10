package api.conifg

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy
import javax.sql.DataSource

/**
 * Application.ymlから設定値を取得する
 * 参考記事 https://qiita.com/ato1234/items/764b79b0d43402724dae
 */
class DbConfig {

    @Value("\${spring.datasource.username}")
    val username = ""

    @Value("\${spring.datasource.password}")
    val password = ""

    @Value("\${spring.datasource.url}")
    val url = ""

    @Value("\${spring.datasource.jdbcDriver}")
    val jdbcDriver = ""

    @Bean
    fun dataSource(): DataSource{
        return TransactionAwareDataSourceProxy(
            DataSourceBuilder.create().username(username).password(password).url(url).driverClassName(jdbcDriver).build()
        )
    }
}