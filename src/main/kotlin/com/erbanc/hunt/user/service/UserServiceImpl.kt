package com.erbanc.hunt.user.service

import com.erbanc.hunt.user.bean.UserBean
import com.erbanc.hunt.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(private val userRepository: UserRepository) : UserService {
    override fun getUser(username: String): UserBean = userRepository.findById(username).map {
        UserBean(
            username = it.username,
            email = it.email,
            questionReached = it.questionReached
        )
    }.orElseThrow()
}