package br.com.project.core.components

import br.com.project.core.exception.DefaultException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionHandlerComponent {
    @ExceptionHandler(value = [DefaultException::class])
    fun handleServiceException(exception: DefaultException): ResponseEntity<Map<String, Any>> {
        val jsonApiErrorAttributes: MutableMap<String, Any?> = LinkedHashMap()
        jsonApiErrorAttributes[CustomJsonApiErrorComponent.STATUS] = exception.httpStatus.value()
        jsonApiErrorAttributes[CustomJsonApiErrorComponent.TITLE] = exception.httpStatus.reasonPhrase
        jsonApiErrorAttributes[CustomJsonApiErrorComponent.DETAIL] = exception.message
        return ResponseEntity(java.util.Map.of<String, Any>(CustomJsonApiErrorComponent.ERRORS, arrayOf<Map<*, *>>(jsonApiErrorAttributes)), exception.httpStatus)
    }
}