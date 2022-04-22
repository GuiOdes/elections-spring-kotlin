package com.kotlin.elections.service

import com.kotlin.elections.model.Candidate
import com.kotlin.elections.model.Election
import com.kotlin.elections.repository.ElectionRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class ElectionService(
    val repository: ElectionRepository
) {

    fun findAll(): List<Election> {
        return repository.findAll().toList()
    }

    fun findBy(id: Long): ResponseEntity<Election> {
        return repository.findById(id)
            .map { ResponseEntity(it, HttpStatus.OK) }
            .orElse(ResponseEntity.notFound().build())
    }

    fun create(election: Election): ResponseEntity<Election> {
        return ResponseEntity(repository.save(election), HttpStatus.CREATED)
    }

    fun update(election: Election): ResponseEntity<Election> {
        return repository.findById(election.id!!)
            .map {
                it.dateElection = election.dateElection
                it.candidateList = election.candidateList
                it.winner = election.winner
                ResponseEntity(repository.save(it), HttpStatus.CREATED)
            }
            .orElse(ResponseEntity.notFound().build())
    }

    fun deleteBy(id: Long): ResponseEntity<Unit> {
        return repository.findById(id)
            .map { ResponseEntity(repository.delete(it), HttpStatus.OK) }
            .orElse(ResponseEntity.notFound().build())
    }

    fun candidateAdd(election: Election, candidate: Candidate): ResponseEntity<Election>{
        return repository.findById(election.id!!)
            .map {
                it.candidateList.add(candidate)
                ResponseEntity(repository.save(it), HttpStatus.CREATED)
            }
            .orElse(ResponseEntity.badRequest().build())
    }

    fun candidateRemove(election: Election, candidate: Candidate): ResponseEntity<Election> {
        return repository.findById(election.id!!)
            .map {
                election.candidateList.remove(candidate)
                ResponseEntity(election, HttpStatus.OK)
            }
            .orElse(ResponseEntity(election, HttpStatus.NOT_FOUND))
    }

    fun findCandidatesBy(electionId: Long): ResponseEntity<MutableList<Candidate>> {
        return repository.findById(electionId)
            .map { ResponseEntity(it.candidateList, HttpStatus.OK)}
            .orElse(ResponseEntity.notFound().build())
    }
}