package com.erbanc.hunt.stats.web

import com.erbanc.hunt.stats.bean.LeaderboardBean
import com.erbanc.hunt.stats.bean.UserStatsBean
import com.erbanc.hunt.stats.service.UserStatsService
import com.erbanc.hunt.user.bean.UserBean
import com.erbanc.hunt.user.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/stats")
class StatsController(private val statsService: UserStatsService) {

    @GetMapping("/{username}")
    fun getUser(@PathVariable username: String): UserStatsBean = statsService.getUserStats(username)

    @GetMapping("/leaderboard")
    fun getLeaderboard(): LeaderboardBean = statsService.getLeaderboard()
}
