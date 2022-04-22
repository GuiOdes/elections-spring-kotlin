package com.kotlin.elections.controller

import com.kotlin.elections.model.Candidate
import com.kotlin.elections.model.Election
import com.kotlin.elections.service.ElectionService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/election")
class ElectionController(
    val service: ElectionService
) {

    @GetMapping("/find")
    fun findAll(): List<Election> {
        return service.findAll()
    }

    @GetMapping("/find/{id}")
    fun findBy(@PathVariable id: Long): ResponseEntity<Election> {
        return service.findBy(id)
    }

    @GetMapping("/find/{id}/candidates")
    fun findCandidatesBy(@PathVariable electionId: Long): ResponseEntity<MutableList<Candidate>> {
        return service.findCandidatesBy(electionId)
    }

    @PostMapping("/new")
    fun create(@RequestBody election: Election): ResponseEntity<Election> {
        return service.create(election)
    }

    @PutMapping("/update")
    fun update(@RequestBody election: Election): ResponseEntity<Election> {
        return service.update(election)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteBy(@PathVariable id: Long): ResponseEntity<Unit> {
        return service.deleteBy(id)
    }

    @PostMapping("/candidates/add")
    fun candidateAdd(@RequestBody election: Election, @RequestBody candidate: Candidate): ResponseEntity<Election> {
        return service.candidateAdd(election, candidate)
    }

    @PostMapping("/candidates/remove")
    fun candidateRemove(@RequestBody election: Election, @RequestBody candidate: Candidate): ResponseEntity<Election> {
        return service.candidateRemove(election, candidate)
    }
}