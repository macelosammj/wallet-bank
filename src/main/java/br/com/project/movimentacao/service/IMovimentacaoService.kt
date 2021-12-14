package br.com.project.movimentacao.service

import br.com.project.conta.entidade.Conta
import br.com.project.movimentacao.dto.ExtratoDTO
import br.com.project.movimentacao.dto.OperacaoDTO
import br.com.project.movimentacao.dto.TransferenciaDTO

interface IMovimentacaoService {
    fun sacar(dto: OperacaoDTO, destino: Conta)
    fun depositar(dto: OperacaoDTO, destino: Conta)
    fun transferir(dto: TransferenciaDTO, origem: Conta, destino: Conta)
    fun extrato(conta: Conta): List<ExtratoDTO>
}