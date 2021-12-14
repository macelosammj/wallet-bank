package br.com.project.core.components

import org.springframework.boot.web.error.ErrorAttributeOptions
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes
import org.springframework.stereotype.Component
import org.springframework.web.context.request.WebRequest

@Component
class CustomJsonApiErrorComponent : DefaultErrorAttributes() {
    override fun getErrorAttributes(webRequest: WebRequest, options: ErrorAttributeOptions): Map<String, Any> {
        val errorAttributes = super.getErrorAttributes(webRequest, options)
        val jsonApiErrorAttributes: MutableMap<String, Any?> = LinkedHashMap()
        jsonApiErrorAttributes[STATUS] = errorAttributes["status"]
        jsonApiErrorAttributes[TITLE] = errorAttributes["error"]
        jsonApiErrorAttributes[DETAIL] = errorAttributes["message"]
        return java.util.Map.of<String, Any>(ERRORS, arrayOf<Map<*, *>>(jsonApiErrorAttributes))
    }

    companion object {
        const val STATUS = "status"
        const val TITLE = "title"
        const val DETAIL = "detail"
        const val ERRORS = "errors"
    }
}