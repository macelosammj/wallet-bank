package br.com.project.movimentacao.repository

import br.com.project.conta.entidade.Conta
import br.com.project.movimentacao.entidade.Movimentacao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface MovimentacaoRepository : JpaRepository<Movimentacao, Long>, JpaSpecificationExecutor<Movimentacao> {
    @Query("SELECT m FROM Movimentacao m WHERE " +
            "(m.operacao = 0 AND m.destino = :conta) OR" +
            "(m.operacao = 1 AND m.origem = :conta)")
    fun extrato(@Param("conta") conta: Conta): List<Movimentacao>
}