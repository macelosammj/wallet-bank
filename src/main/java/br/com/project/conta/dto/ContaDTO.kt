package br.com.project.conta.dto

import br.com.project.banco.dto.BancoDTO
import br.com.project.conta.entidade.Conta
import com.fasterxml.jackson.annotation.JsonProperty

data class ContaDTO(
        @JsonProperty("id") val id: Long? = null,
        @JsonProperty("numero", required = true) val numero: Long? = null,
        @JsonProperty("banco") val banco: BancoDTO? = null
) {

    constructor(conta: Conta) : this(conta.id, conta.numero, BancoDTO(conta.banco!!))

    companion object {
        fun valueOf(value: ContaDTO): Conta = Conta().apply {
            id = value.id
            numero = value.numero
            banco = value.banco?.let { BancoDTO.valueOf(it) }
        }
    }
}