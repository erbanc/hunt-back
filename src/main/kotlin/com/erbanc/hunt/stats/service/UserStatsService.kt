package com.erbanc.hunt.stats.service

interface UserStatsService {

    fun updateStats(username: String, validGuess: Boolean)
}