package br.com.project

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.core.task.TaskExecutor
import org.springframework.scheduling.annotation.AsyncConfigurerSupport
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import java.util.concurrent.Executor


@SpringBootApplication
@EnableAsync
class MainApplication: AsyncConfigurerSupport() {

    @Bean(name = ["AsyncPool"])
    override fun getAsyncExecutor(): Executor {
        val executor = ThreadPoolTaskExecutor()
        executor.corePoolSize = 50
        executor.maxPoolSize = 100
        executor.setQueueCapacity(50)
        executor.setWaitForTasksToCompleteOnShutdown(false)
        executor.setThreadNamePrefix("Async-")
        executor.initialize()
        return executor
    }
}

fun main(args: Array<String>) {
    runApplication<MainApplication>(*args)

}
