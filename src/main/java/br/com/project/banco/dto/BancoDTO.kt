package br.com.project.banco.dto

import br.com.project.banco.entidade.Banco
import com.fasterxml.jackson.annotation.JsonProperty

data class BancoDTO(
        @JsonProperty("id") val id: Long? = null,
        @JsonProperty("codigo_banco") val codigoBanco: Long? = null,
        @JsonProperty("agencia") val agencia: Long? = null,
) {

    constructor(banco: Banco) : this(banco.id, banco.codigoBanco, banco.numeroAgencia)

    companion object {
        fun valueOf(dto: BancoDTO): Banco {
            val banco = Banco()
            banco.codigoBanco = dto.codigoBanco
            banco.id = dto.id
            banco.numeroAgencia = dto.agencia
            return banco
        }
    }
}