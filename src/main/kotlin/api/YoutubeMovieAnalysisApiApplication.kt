package api

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["api"])
@MapperScan("api.mapper")
class YoutubeMovieAnalysisApiApplication

fun main(args: Array<String>) {
    runApplication<YoutubeMovieAnalysisApiApplication>(*args)
}
