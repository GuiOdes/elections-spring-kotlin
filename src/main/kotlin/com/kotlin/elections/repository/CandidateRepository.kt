package com.kotlin.elections.repository

import com.kotlin.elections.model.Candidate
import org.springframework.data.repository.CrudRepository

interface CandidateRepository : CrudRepository<Candidate, Long>