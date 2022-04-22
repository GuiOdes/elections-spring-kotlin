package com.kotlin.elections.repository

import com.kotlin.elections.model.Vote
import org.springframework.data.repository.CrudRepository

interface VoteRepository: CrudRepository<Vote, Long>