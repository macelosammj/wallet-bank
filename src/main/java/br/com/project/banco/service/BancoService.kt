package br.com.project.banco.service

import br.com.project.banco.dto.BancoDTO
import br.com.project.banco.entidade.Banco
import br.com.project.banco.exception.BancoNaoEncontradoException
import br.com.project.banco.repository.BancoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class BancoService {
    @Autowired
    private lateinit var repository: BancoRepository

    fun getBanco(id: Long): BancoDTO = repository.findById(id)
            .map { banco: Banco -> BancoDTO(banco) }
            .orElseThrow { BancoNaoEncontradoException(id) }

    fun saveUpdate(dto: BancoDTO): BancoDTO = BancoDTO(repository.save(BancoDTO.valueOf(dto)))

    fun getPaged(page: Int, limit: Int): Page<BancoDTO> =
            repository.findAll(PageRequest.of(page, limit)).map { banco: Banco -> BancoDTO(banco) }

    fun delete(id: Long) {
        repository.deleteById(id)
    }
}