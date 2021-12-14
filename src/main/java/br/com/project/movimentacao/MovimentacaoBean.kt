package br.com.project.movimentacao

import br.com.project.movimentacao.service.IMovimentacaoService
import br.com.project.movimentacao.service.MovimentacaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MovimentacaoBean {

    @Autowired
    private lateinit var movimentacaoService: MovimentacaoService

    //Service Injection
    @Bean
    fun imovimentacaoService(): IMovimentacaoService = movimentacaoService
}