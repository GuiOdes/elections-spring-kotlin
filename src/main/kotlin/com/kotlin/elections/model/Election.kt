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
    val dateElection: LocalDate,

    @Enumerated(EnumType.STRING)
    val electionType: ElectionType,

    @JoinColumn
    @ManyToMany
    var candidateList: List<Candidate>,

    @JoinColumn
    @ManyToOne
    val winner: Candidate?,

    @OneToMany(mappedBy = "election")
    val votes: List<Vote>
)