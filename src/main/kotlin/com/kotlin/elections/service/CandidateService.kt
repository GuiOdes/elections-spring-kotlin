package com.kotlin.elections.service

import com.kotlin.elections.model.Candidate
import com.kotlin.elections.repository.CandidateRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class CandidateService(
    val repository: CandidateRepository
) {

    fun findAll(): List<Candidate> {
        return repository.findAll().toList()
    }

    fun findBy(id: Long): ResponseEntity<Candidate> {
        return repository.findById(id)
            .map { ResponseEntity(it, HttpStatus.OK) }
            .orElse(ResponseEntity.notFound().build())
    }

    fun create(candidate: Candidate): ResponseEntity<Candidate> {
        return ResponseEntity(repository.save(candidate), HttpStatus.CREATED)
    }

    fun update(candidate: Candidate): ResponseEntity<Candidate> {
        return repository.findById(candidate.id!!)
            .map {
                it.number = candidate.number
                it.birth = candidate.birth
                it.gender = candidate.gender
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