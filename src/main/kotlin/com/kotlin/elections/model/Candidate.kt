package com.kotlin.elections.model

import com.kotlin.elections.model.enums.Gender
import java.time.LocalDate
import javax.persistence.*

@Entity
class Candidate (

    name: String,
    birth: LocalDate,
    gender: Gender,

    @Column
    val number: Int,

    @Column
    var votes: Int
) : Person (
    name = name,
    birth = birth,
    gender = gender
)