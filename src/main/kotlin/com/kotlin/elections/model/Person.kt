package com.kotlin.elections.model

import com.kotlin.elections.model.enums.Gender
import java.time.LocalDate
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
open abstract class Person (
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     open val id: Long? = null,

     @Column
     open var name: String,

     @Column
     open val birth: LocalDate,

     @Enumerated(EnumType.STRING)
     open val gender: Gender
)