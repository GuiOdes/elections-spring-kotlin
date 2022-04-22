package com.kotlin.elections.service

import com.kotlin.elections.model.Vote
import com.kotlin.elections.repository.VoteRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class VoteService(
    val repository: VoteRepository
) {

    fun create(vote: Vote): ResponseEntity<Vote> {
        return ResponseEntity(repository.save(vote), HttpStatus.CREATED)
    }

}