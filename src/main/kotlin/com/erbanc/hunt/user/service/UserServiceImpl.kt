package com.erbanc.hunt.user.service

import com.erbanc.hunt.stats.entity.UserStatsEntity
import com.erbanc.hunt.stats.repository.UserStatsRepository
import com.erbanc.hunt.user.bean.UserBean
import com.erbanc.hunt.user.entity.UserEntity
import com.erbanc.hunt.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(private val userRepository: UserRepository, private val userStatsRepository: UserStatsRepository) : UserService {
    override fun getUser(username: String): UserBean = userRepository.findById(username).map {
        UserBean(
            username = it.username,
            email = it.email,
            questionReached = it.questionReached
        )
    }.orElseThrow { RuntimeException("No user with this username") }

    override fun addUser(user: UserBean, password: String) {
        val userCreated: UserEntity = userRepository.save(UserEntity(username = user.username, email = user.email, password = password))

        userStatsRepository.save(UserStatsEntity(username = userCreated.username))
    }
}