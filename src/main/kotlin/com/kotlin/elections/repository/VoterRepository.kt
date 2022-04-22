package com.kotlin.elections.repository

import com.kotlin.elections.model.Voter
import org.springframework.data.repository.CrudRepository

interface VoterRepository: CrudRepository<Voter, Long>