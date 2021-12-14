package br.com.project.banco.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.NO_CONTENT)
class BancoNaoEncontradoException(id: Long) : RuntimeException("Nenhum banco contrado : $id")