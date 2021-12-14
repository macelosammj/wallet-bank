package br.com.project.conta.controller

import br.com.project.conta.dto.ContaDTO
import br.com.project.conta.service.ContaService
import br.com.project.movimentacao.dto.OperacaoDTO
import br.com.project.movimentacao.dto.TransferenciaDTO
import br.com.project.movimentacao.service.IMovimentacaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/conta")
class ContaController {

    @Autowired
    private lateinit var contaService: ContaService

    @GetMapping("/")
    @ResponseBody
    fun get(@RequestParam numero: Long): ContaDTO = contaService.find(numero)

    @PostMapping("/")
    @ResponseBody
    fun post(@RequestBody contaDTO: ContaDTO): ContaDTO = contaService.saveUpdate(contaDTO)

    @PostMapping("/{id}/depositar")
    @ResponseBody
    fun deposito(@PathVariable id: Long, @RequestBody dto: OperacaoDTO) {
        contaService.depositar(id, dto)
    }

    @PostMapping("/{id}/sacar")
    @ResponseBody
    fun sacar(@PathVariable id: Long, @RequestBody dto: OperacaoDTO) {
        contaService.sacar(id, dto)
    }

    @PostMapping("/transferir")
    @ResponseBody
    fun transferir(@RequestBody dto: TransferenciaDTO) {
        contaService.transferir(dto)
    }

    @PostMapping("/{id}/extrato")
    @ResponseBody
    fun extrato(@PathVariable id: Long) = contaService.extrato(id)
}