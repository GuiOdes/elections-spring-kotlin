package com.kotlin.elections.service

import com.kotlin.elections.model.Voter
import com.kotlin.elections.repository.VoterRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class VoterService (
    val repository: VoterRepository
) {

    fun findAll(): List<Voter> {
        return repository.findAll().toList()
    }

    fun findBy(id: Long): ResponseEntity<Voter> {
        return repository.findById(id)
            .map { ResponseEntity(it, HttpStatus.OK) }
            .orElse(ResponseEntity.notFound().build())
    }

    fun create(voter: Voter): ResponseEntity<Voter> {
        return ResponseEntity(repository.save(voter), HttpStatus.CREATED)
    }

    fun update(voter: Voter): ResponseEntity<Voter> {
        return repository.findById(voter.id!!)
            .map {
                it.cpf = voter.cpf
                it.name = voter.name
                it.birth = voter.birth
                it.gender = voter.gender
                ResponseEntity(repository.save(it), HttpStatus.CREATED)
            }
            .orElse(ResponseEntity.notFound().build())
    }

    fun deleteBy(id: Long): ResponseEntity<Unit> {
        return repository.findById(id)
            .map { ResponseEntity(repository.delete(it), HttpStatus.OK) }
            .orElse(ResponseEntity.notFound().build())
    }
}