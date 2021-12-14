package br.com.project.conta.entidade

import br.com.project.banco.entidade.Banco
import javax.persistence.*


@Entity
@Table(name = "tb_conta")
@SequenceGenerator(name = "seq", sequenceName = "conta_values_seq", allocationSize = 1)
class Conta {
    @Id
    @Column(name = "id_conta")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    var id: Long? = null

    @Column(name = "numero")
    var numero: Long? = null

    @Column(name = "saldo")
    var saldo: Long? = null

    @ManyToOne
    @JoinColumn(name = "id_banco", referencedColumnName = "id_banco")
    var banco: Banco? = null


}