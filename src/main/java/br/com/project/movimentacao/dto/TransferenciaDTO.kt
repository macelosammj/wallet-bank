package br.com.project.movimentacao.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class TransferenciaDTO(@JsonProperty("conta", required = true) val numeroConta: Long,
                            @JsonProperty("destino", required = true) val numeroDestino: Long,
                            @JsonProperty("valor", required = true) val valor: Long)