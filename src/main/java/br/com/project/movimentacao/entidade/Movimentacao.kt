package br.com.project.movimentacao.entidade

import br.com.project.conta.entidade.Conta
import javax.persistence.*

@Entity
@Table(name = "tb_movimentacao")
@SequenceGenerator(name = "seq", sequenceName = "movimentacao_values_seq", allocationSize = 1)
class Movimentacao {
    @Id
    @Column(name = "id_movimentacao")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    var id: Long? = null

    @Column(name = "value")
    var valor: Long = 0

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "operation_type")
    lateinit var operacao: Operacao

    @ManyToOne
    @JoinColumn(name = "id_origem", referencedColumnName = "id_conta", nullable = true)
    var origem: Conta? = null

    @ManyToOne
    @JoinColumn(name = "id_destino", referencedColumnName = "id_conta", nullable = true)
    var destino: Conta? = null

    enum class Operacao {
        ENTRADA, SAIDA
    }

    class Builder(val valor: Long, val operacao: Operacao) {
        private var origem: Conta? = null
        private var destino: Conta? = null

        fun setOrigem(origem: Conta): Builder {
            this.origem = origem
            return this
        }

        fun setDestino(destino: Conta): Builder {
            this.destino = destino
            return this
        }

        fun build() = Movimentacao().also {
            it.valor = valor
            it.operacao = operacao
            it.origem = origem
            it.destino = destino
        }
    }

}