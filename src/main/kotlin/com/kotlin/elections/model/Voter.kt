package com.kotlin.elections.model

import com.kotlin.elections.model.enums.Gender
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.OneToMany

@Entity
class Voter (
    name: String,
    birth: LocalDate,
    gender: Gender,

    @Column
    var cpf: String,

    @OneToMany(mappedBy = "voter")
    var votes: List<Vote>

) : Person (
    name = name,
    birth = birth,
    gender = gender
)