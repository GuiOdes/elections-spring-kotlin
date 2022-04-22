package com.kotlin.elections.model

import javax.persistence.*

@Entity
@Table(name = "tb_vote")
class Vote(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,

    @JoinColumn
    @ManyToOne
    val voter: Voter,

    @JoinColumn
    @ManyToOne
    val election: Election,

    @Column
    val vote: Int
)