package br.com.project.movimentacao.dto

import br.com.project.conta.dto.ContaDTO
import br.com.project.movimentacao.entidade.Movimentacao
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ExtratoDTO(@JsonProperty("conta_origem") val contaOrigem: ContaDTO?,
                      @JsonProperty("conta_destino") val contaDestino: ContaDTO?,
                      @JsonProperty("operacao") val operacao: String,
                      @JsonProperty("valor") val valor: Long) {
    constructor(movimentacao: Movimentacao) : this(
            movimentacao.origem?.let { ContaDTO(it) },
            movimentacao.destino?.let { ContaDTO(it) },
            movimentacao.operacao.name,
            movimentacao.valor)
}