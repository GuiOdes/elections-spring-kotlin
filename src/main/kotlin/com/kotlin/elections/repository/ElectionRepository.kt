package com.kotlin.elections.repository

import com.kotlin.elections.model.Election
import org.springframework.data.repository.CrudRepository

interface ElectionRepository: CrudRepository<Election, Long>