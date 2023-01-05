package com.erbanc.hunt.stats.service

import com.erbanc.hunt.stats.bean.LeaderboardBean
import com.erbanc.hunt.stats.bean.UserStatsBean

interface UserStatsService {

    fun updateStats(username: String, validGuess: Boolean)

    fun getUserStats(username: String): UserStatsBean

    fun getLeaderboard(): LeaderboardBean
}
