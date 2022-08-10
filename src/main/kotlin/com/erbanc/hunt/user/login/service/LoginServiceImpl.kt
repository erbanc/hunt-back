package com.erbanc.hunt.user.login.service

import com.erbanc.hunt.user.login.bean.LoginBean
import com.erbanc.hunt.user.login.bean.LoginResultBean
import com.erbanc.hunt.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class LoginServiceImpl(private val userRepository: UserRepository) : LoginService {

    override fun validateLogin(loginBean: LoginBean): LoginResultBean {

        val login = userRepository.getByLogin(loginBean.username, loginBean.password)
        return if (login.isEmpty()) {
            LoginResultBean(false, null)
        } else {
            val user = login[0]
            LoginResultBean(true, user.username)
        }
    }
}