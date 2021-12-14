package br.com.project.conta.repository

import br.com.project.conta.entidade.Conta
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ContaRepository : JpaRepository<Conta, Long>, JpaSpecificationExecutor<Conta> {
    fun findByNumero(numero: Long): Optional<Conta>
}