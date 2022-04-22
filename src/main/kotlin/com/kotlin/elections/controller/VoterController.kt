package com.kotlin.elections.controller

import com.kotlin.elections.model.Voter
import com.kotlin.elections.service.VoterService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

class VoterController(
    val service: VoterService
) {

    @GetMapping("/find")
    fun findAll(): List<Voter> {
        return service.findAll()
    }

    @GetMapping("/find/{id}")
    fun findBy(@PathVariable id: Long): ResponseEntity<Voter> {
        return service.findBy(id)
    }

    @PostMapping("/new")
    fun create(@RequestBody voter: Voter): ResponseEntity<Voter> {
        return service.create(voter)
    }

    @PostMapping("/update")
    fun update(@RequestBody voter: Voter): ResponseEntity<Voter> {
        return service.update(voter)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteBy(@PathVariable id: Long): ResponseEntity<Unit> {
        return service.deleteBy(id)
    }
}