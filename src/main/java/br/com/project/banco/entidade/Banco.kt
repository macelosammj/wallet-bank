package br.com.project.banco.entidade

import javax.persistence.*

@Entity
@Table(name = "tb_banco")
@SequenceGenerator(name = "seq", sequenceName = "banco_values_seq", allocationSize = 1)
class Banco {
 @Id
 @Column(name = "id_banco")
 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
 var id: Long? = null

 @Column(name = "codigo_banco")
 var codigoBanco: Long? = null

 @Column(name = "numero_agencia")
 var numeroAgencia: Long? = null

}