package br.com.project.conta.service

import br.com.project.conta.dto.ContaDTO
import br.com.project.conta.exception.ContaNaoEncontradaException
import br.com.project.conta.repository.ContaRepository
import br.com.project.movimentacao.dto.OperacaoDTO
import br.com.project.movimentacao.dto.TransferenciaDTO
import br.com.project.movimentacao.service.IMovimentacaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
internal class ContaService {

    @Autowired
    private lateinit var movimentacaoService: IMovimentacaoService

    @Autowired
    private lateinit var repository: ContaRepository

    fun find(number: Long): ContaDTO = repository.findByNumero(number).run {
        if (isPresent)
            return map { ContaDTO(it) }.orElseThrow { ContaNaoEncontradaException(number) }
        else
            throw ContaNaoEncontradaException(number)
    }

    fun saveUpdate(contaDTO: ContaDTO): ContaDTO = ContaDTO(repository.save(ContaDTO.valueOf(contaDTO)))

    fun transferir(dto: TransferenciaDTO) {
        movimentacaoService.transferir(
                dto,
                repository.findByNumero(dto.numeroConta).get(),
                repository.findByNumero(dto.numeroDestino).get())
    }

    fun sacar(id: Long, dto: OperacaoDTO) {
        with(repository.findByNumero(id).get()) {
            saldo = saldo?.minus(dto.valor)
            repository.save(this)
            movimentacaoService.sacar(dto, this)
        }
    }

    @Transactional
    fun depositar(id: Long, dto: OperacaoDTO) {
        with(repository.findByNumero(id).get()) {
            saldo = saldo?.plus(dto.valor)
            repository.save(this)
            movimentacaoService.depositar(dto, this)
        }
    }

    fun extrato(id: Long) = movimentacaoService.extrato(repository.findByNumero(id).get())
}