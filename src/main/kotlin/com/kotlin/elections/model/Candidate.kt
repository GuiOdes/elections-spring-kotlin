package com.kotlin.elections.model

import com.kotlin.elections.model.enums.Gender
import java.time.LocalDate

class Candidate (
    name: String,
    birth: LocalDate,
    gender: Gender,
    val number: Int,
    var votes: Int
) : Person (
    name = name,
    birth = birth,
    gender = gender
)