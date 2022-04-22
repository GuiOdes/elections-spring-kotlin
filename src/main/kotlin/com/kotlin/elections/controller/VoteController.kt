package com.kotlin.elections.controller

import com.kotlin.elections.model.Vote
import com.kotlin.elections.service.VoteService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/vote")
class VoteController(
    val service: VoteService
) {

    @PostMapping("/new")
    fun create(@RequestBody vote: Vote): ResponseEntity<Vote> {
        return service.create(vote)
    }
}