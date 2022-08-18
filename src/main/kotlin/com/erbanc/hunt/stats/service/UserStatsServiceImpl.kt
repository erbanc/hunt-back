package com.erbanc.hunt.stats.service

import com.erbanc.hunt.stats.repository.UserStatsRepository
import org.springframework.stereotype.Service

@Service
class UserStatsServiceImpl(private val userStatsRepository: UserStatsRepository) : UserStatsService {

    override fun updateStats(username: String, validGuess: Boolean) {
        userStatsRepository.findById(username).ifPresent {
            it.totalGuesses++
            if (!validGuess) it.totalBadGuesses++
            userStatsRepository.save(it)
        }
    }
}