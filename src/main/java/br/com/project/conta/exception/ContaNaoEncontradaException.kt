package br.com.project.conta.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.NO_CONTENT)
class ContaNaoEncontradaException(id: Long) : RuntimeException("Nenhuma conta contrado : $id")