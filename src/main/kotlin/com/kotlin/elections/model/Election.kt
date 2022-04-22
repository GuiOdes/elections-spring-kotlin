package com.kotlin.elections.model

import com.kotlin.elections.model.enums.ElectionType
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "tb_election")
class Election (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,

    @Column
    var dateElection: LocalDate,

    @Enumerated(EnumType.STRING)
    val electionType: ElectionType,

    @JoinColumn
    @ManyToMany
    var candidateList: MutableList<Candidate>?,

    @JoinColumn
    @ManyToOne
    var winner: Candidate?,

    @OneToMany(mappedBy = "election")
    val votes: List<Vote>?
)