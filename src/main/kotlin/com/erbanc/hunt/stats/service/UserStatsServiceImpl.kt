package com.erbanc.hunt.stats.service

import com.erbanc.hunt.stats.bean.LeaderboardBean
import com.erbanc.hunt.stats.bean.UserStatsBean
import com.erbanc.hunt.stats.entity.UserStatsEntity
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

    override fun getUserStats(username: String): UserStatsBean {

        val allUserStats = userStatsRepository.findAll()

        return userStatsRepository.findById(username).map {
            UserStatsBean(
                username = username,
                questionsSolved = it.getNumberSolvedQuestions(),
                rank = getRank(it, allUserStats),
                totalBadGuesses = it.totalBadGuesses,
                totalGuesses = it.totalGuesses
            )
        }.orElseThrow { RuntimeException("No user with this username") }
    }

    override fun getLeaderboard(): LeaderboardBean {

        val allUserStats = userStatsRepository.findAll()

        // Rank users by right guesses and then by less wrong guesses
        return LeaderboardBean(allUserStats.map { us ->
            UserStatsBean(
                username = us.username,
                rank = getRank(us, allUserStats),
                totalGuesses = us.totalGuesses,
                totalBadGuesses = us.totalBadGuesses,
                questionsSolved = us.getNumberSolvedQuestions()
            )
        })
    }

    fun getRank(userStats: UserStatsEntity, allUserStats: List<UserStatsEntity>): Long =
        allUserStats.filter { userStatsBean ->
            userStatsBean.getNumberSolvedQuestions() > userStats.getNumberSolvedQuestions() || (userStatsBean.getNumberSolvedQuestions() == userStats.getNumberSolvedQuestions() && userStatsBean.totalBadGuesses < userStats.totalBadGuesses)
        }.size.toLong()
}
