package br.com.project.movimentacao.service

import br.com.project.conta.entidade.Conta
import br.com.project.movimentacao.dto.ExtratoDTO
import br.com.project.movimentacao.dto.OperacaoDTO
import br.com.project.movimentacao.dto.TransferenciaDTO
import br.com.project.movimentacao.entidade.Movimentacao
import br.com.project.movimentacao.repository.MovimentacaoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.concurrent.CompletableFuture

@Service
class MovimentacaoService : IMovimentacaoService {

    @Autowired
    private lateinit var repository: MovimentacaoRepository

    override fun depositar(dto: OperacaoDTO, destino: Conta) {
        repository.save(Movimentacao
                .Builder(dto.valor, Movimentacao.Operacao.ENTRADA)
                .setDestino(destino).build())
    }

    override fun sacar(dto: OperacaoDTO, destino: Conta) {
        repository.save(Movimentacao
                .Builder(dto.valor, Movimentacao.Operacao.SAIDA)
                .setOrigem(destino)
                .build())
    }

    @Transactional
    override fun transferir(dto: TransferenciaDTO, origem: Conta, destino: Conta) {
        CompletableFuture.runAsync {
            try {
                Thread.sleep(10000L)
            } catch (e: InterruptedException ) {
                e.printStackTrace()
            }
            println()
        }
        repository.save(Movimentacao
                .Builder(dto.valor, Movimentacao.Operacao.SAIDA)
                .setOrigem(origem)
                .setDestino(destino).build())
        repository.save(Movimentacao
                .Builder(dto.valor, Movimentacao.Operacao.ENTRADA)
                .setOrigem(origem)
                .setDestino(destino).build())
    }

    override fun extrato(conta: Conta) = conta.let {
        return@let repository
                .extrato(it)
    }.map { ExtratoDTO(it) }
}