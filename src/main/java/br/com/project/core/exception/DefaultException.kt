package br.com.project.core.exception

import org.springframework.http.HttpStatus

class DefaultException(val httpStatus: HttpStatus, statusText: String?) : RuntimeException(statusText)