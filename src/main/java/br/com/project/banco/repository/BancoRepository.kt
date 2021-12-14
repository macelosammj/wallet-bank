package br.com.project.banco.repository

import br.com.project.banco.entidade.Banco
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface BancoRepository : JpaRepository<Banco, Long>, JpaSpecificationExecutor<Banco>