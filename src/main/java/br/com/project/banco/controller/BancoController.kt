package br.com.project.banco.controller

import br.com.project.banco.dto.BancoDTO
import br.com.project.banco.service.BancoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/banco")
class BancoController {

    @Autowired
    private lateinit var bancoService: BancoService

    @GetMapping("/{id}")
    @ResponseBody
    fun get(@PathVariable id: Long): BancoDTO = bancoService.getBanco(id)

    @PostMapping("/")
    @ResponseBody
    fun post(@RequestBody dto: BancoDTO): BancoDTO = bancoService.saveUpdate(dto)

    @PutMapping("/")
    @ResponseBody
    fun put(@RequestBody dto: BancoDTO): BancoDTO = bancoService.saveUpdate(dto)

    @DeleteMapping("/{id}")
    @ResponseBody
    fun delete(@PathVariable id: Long) {
        bancoService.delete(id)
    }

    @GetMapping("/{page}/{limit}")
    @ResponseBody
    fun getPaged(@PathVariable page: Int,
                 @PathVariable limit: Int): Page<BancoDTO> = bancoService.getPaged(page, limit)
}