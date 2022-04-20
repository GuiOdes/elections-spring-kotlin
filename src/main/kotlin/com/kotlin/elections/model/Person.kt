package com.kotlin.elections.model

import com.kotlin.elections.model.enums.Gender
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "tb_person")
open class Person (
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     val id: Long? = null,

     @Column
     var name: String,

     @Column
     val birth: LocalDate,

     @Enumerated(EnumType.STRING)
     val gender: Gender
)