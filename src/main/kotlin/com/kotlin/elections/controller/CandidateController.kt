package com.kotlin.elections.controller

import com.kotlin.elections.model.Candidate
import com.kotlin.elections.service.CandidateService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Controller
class CandidateController(
    val service: CandidateService
) {

    @GetMapping("/find")
    fun findAll(): List<Candidate> {
        return service.findAll()
    }

    @GetMapping("/find/{id}")
    fun findBy(@PathVariable id: Long): ResponseEntity<Candidate> {
        return service.findBy(id)
    }

    @PostMapping("/new")
    fun create(@RequestBody candidate: Candidate): ResponseEntity<Candidate> {
        return service.create(candidate)
    }

    @PostMapping("/update")
    fun update(@RequestBody candidate: Candidate): ResponseEntity<Candidate> {
        return service.update(candidate)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteBy(@PathVariable id: Long): ResponseEntity<Unit> {
        return service.deleteBy(id)
    }
}