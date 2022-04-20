package com.kotlin.elections.model

import com.kotlin.elections.model.enums.Gender
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "tb_person")
class Person (
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     val id: Long,

     @Column
     var name: String,

     @Column
     val birth: LocalDate,

     @Enumerated(EnumType.STRING)
     val gender: Gender
)