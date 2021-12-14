package br.com.project.movimentacao.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class OperacaoDTO(@JsonProperty("valor", required = true) val valor: Long)